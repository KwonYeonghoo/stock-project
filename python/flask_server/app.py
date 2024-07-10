from flask import Flask, render_template
from flask_sqlalchemy import SQLAlchemy
import pymysql
import requests
import os
from dotenv import load_dotenv
import google.generativeai as genai
import MySQLdb

# .env파일에 선언된 환경변수들 load
load_dotenv()

# db 환경변수
DB_HOST = os.getenv("DB_HOST")
DB_USER = os.getenv("DB_USER")
DB_PASSWORD = os.getenv("DB_PASSWORD")
DB_NAME = os.getenv("DB_NAME")
DB_CHARSET = os.getenv("DB_CHARSET")

# Gemini configuration
GEM_API_KEY = os.getenv("GEM_API_KEY")
genai.configure(api_key=GEM_API_KEY)
genai_config = genai.GenerationConfig(temperature = 0.8)
MODEL = genai.GenerativeModel(model_name = 'gemini-pro', generation_config=genai_config)

# 애플리케이션 생성
app = Flask(__name__)
# Flask-SQLAlchemy db configuration
app.config['SQLALCHEMY_DATABASE_URI'] = f"mysql://{DB_USER}:{DB_PASSWORD}@{DB_HOST}/{DB_NAME}"
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

db = SQLAlchemy(app)


# @app.route('/report/<ticker>')
# def daily_report(ticker):
#     # 날짜별 ticker의
#     # name, industry, price, volume, pct_change, market_cap,
#     # dividend_rate, dividened_yield, per, news_summary
    
#     # 날짜별 industry의
#     # avg_per, avg_pct_change
    
#     return render_template('report.html')

# if __name__ == '__main__':
#     app.run('0.0.0.0', port=8081, debug=True)
    
metadata = MetaData(bind = db.engine)
metadata.reflect()

# 데이터베이스에 있는 테이블 목록 출력
print("현재 데이터베이스에 존재하는 테이블 목록:")
for table in metadata.sorted_tables:
    print(table.name)