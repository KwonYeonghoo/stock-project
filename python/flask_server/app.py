from flask import Flask, render_template
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy import desc
import pymysql
import requests
import os
from dotenv import load_dotenv
import google.generativeai as genai

# .env파일에 선언된 환경변수들 load
load_dotenv()

# db 환경변수
DB_HOST = os.getenv("DB_HOST")
DB_USER = "hoo"
DB_PASSWORD = os.getenv("DB_PASSWORD")
DB_NAME = os.getenv("DB_NAME")
DB_CHARSET = os.getenv("DB_CHARSET")
print(DB_USER)
# Gemini configuration
GEM_API_KEY = os.getenv("GEM_API_KEY")
genai.configure(api_key=GEM_API_KEY)
genai_config = genai.GenerationConfig(temperature = 1.0)
MODEL = genai.GenerativeModel(model_name = 'gemini-pro', generation_config=genai_config)

def generate_report(date, ticker, name, industry, price, volume, pct_change,
                        market_cap, dividend_rate, dividend_yield, per, news_summaries, 
                        avg_per, avg_pct_change):
        prompt = f"""
        {ticker} 볼린저밴드 분석해줘
        """
        try:
            report = MODEL.generate_content(prompt).text
            print(report)
            return report

        except Exception as e:
            return "gemini 오류 발생"
        
        
# 애플리케이션 생성
app = Flask(__name__)
# Flask-SQLAlchemy db configuration
# mysql+pymysql : SqlAlchemy가 MySQL 데이터베이스와 연결할 때 pymysql모듈을 사용하도록 명시적으로 지정
#               : pymysql을 생략하면 SqlAlchemy가 기본적으로 MySQLdb 모듈을 사용하려고 시도
#               : 이 둘 모두 MySQL 데이터베이스와 연결하는 드라이버
#               : 나의 경우에는 MySQLdb가 정상적으로 설치가 안돼서 pymysql모듈을 사용했다.
app.config['SQLALCHEMY_DATABASE_URI'] = f"mysql+pymysql://{DB_USER}:{DB_PASSWORD}@{DB_HOST}/{DB_NAME}"
print(f"후 mysql+pymysql://{DB_USER}:{DB_PASSWORD}@{DB_HOST}/{DB_NAME}")
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

db = SQLAlchemy(app)

# # 데이터베이스에 있는 테이블 목록 출력
# with app.app_context(): # Flask 애플리케이션 컨텍스트 활성화(Flask 애플리케이션 관련 정보를 저장하고 관리하는 환경)
#                         # Flask 애플리케이션은 애플리케이션 컨텍스트에서 동작해야하며,
#                         # 이 블록 내의 모든 코드가 애플리케이션 컨택스트 내에서 실행된다.
#                         # 이는 데이터베이스 세션과 같은 애플리케이션 자원에 접근할 수 있게 해준다.
#     metadata = db.metadata # 테이블, 열, 관계 등의 정보를 담은 db의 스키마
#     metadata.reflect(bind=db.engine) # db.engine: 데이터베이스 연결
#                                         # reflect(bind=db.engine) : db의 메타데이터 정보를 metadata객체에 '반영'하는 메서드
#     print("현재 데이터베이스에 존재하는 테이블 목록:")
#     for table in metadata.sorted_tables: # 정렬된 테이블 리스트
#         print(table.name)

class StockDailyInfo(db.Model):
    __tablename__ = 'stock_daily_info'
    id = db.Column(db.Integer, primary_key=True)
    ticker = db.Column(db.String(10), nullable=False)
    date = db.Column(db.String(20), nullable=False)
    price = db.Column(db.Float, nullable=False)
    volume = db.Column(db.BigInteger, nullable=False)
    avg_volume = db.Column(db.BigInteger, nullable=False)
    pct_change = db.Column(db.Float, nullable=False)
    market_cap = db.Column(db.BigInteger, nullable=False)
    dividend_rate = db.Column(db.Float, nullable=False)
    dividend_yield = db.Column(db.Float, nullable=False)
    per = db.Column(db.Float, nullable=False)
    news_summary = db.Column(db.Text, nullable=False)

class StockList(db.Model):
    ticker = db.Column(db.String(10), primary_key=True)
    name = db.Column(db.String(255), nullable=False)
    industry = db.Column(db.String(255), nullable=False)
    
class IndustryInfo(db.Model):
    industry = db.Column(db.String(255), primary_key=True)
    date = db.Column(db.String(20), primary_key=True)
    avg_market_cap = db.Column(db.Float, nullable=False)
    avg_per = db.Column(db.Float, nullable=False)
    avg_pct_change = db.Column(db.Float, nullable=False)

@app.route('/v1/stock/report/<ticker>')
def get_daily_report(ticker):
    with app.app_context():
        today = StockDailyInfo.query.order_by(desc(StockDailyInfo.date)).first().date
        stock_list_data = StockList.query.filter_by(ticker = ticker).first()
        stock_daily_info = StockDailyInfo.query.filter_by(ticker = ticker, date = today).all()
        stock_daily_info_data = stock_daily_info[0]
        
        name = stock_list_data.name
        industry = stock_list_data.industry
        price = stock_daily_info_data.price
        volume = stock_daily_info_data.volume
        pct_change = stock_daily_info_data.pct_change 
        market_cap = stock_daily_info_data.market_cap
        dividend_rate = stock_daily_info_data.dividend_rate 
        dividend_yield = stock_daily_info_data.dividend_yield 
        per = stock_daily_info_data.per
        news_summaries = {}
        for idx, row in enumerate(stock_daily_info, start=1):
            key = f"news_summary{idx}"
            news_summaries[key] = row.news_summary
        industry_info_data = IndustryInfo.query.filter_by(industry=industry, date=today).first()
        avg_per = industry_info_data.avg_per
        avg_pct_change = industry_info_data.avg_pct_change
        
        report = generate_report(today, ticker, name, industry, price, volume, pct_change,
                        market_cap, dividend_rate, dividend_yield, per, news_summaries, 
                        avg_per, avg_pct_change)
        
        # 변수들을 템플릿에 전달
        return render_template('report.html', 
                                date=today,
                                ticker=ticker,
                                name=name, 
                                industry=industry, 
                                price=price, 
                                volume=volume, 
                                pct_change=pct_change, 
                                market_cap=market_cap, 
                                dividend_rate=dividend_rate, 
                                dividend_yield=dividend_yield, 
                                per=per, 
                                news_summaries=news_summaries,
                                avg_per=avg_per,
                                avg_pct_change=avg_pct_change,
                                report=report)

if __name__ == '__main__':
    app.run('0.0.0.0', port=8081, debug=True)