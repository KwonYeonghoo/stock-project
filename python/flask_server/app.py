from flask import Flask, render_template
import pymysql
import

app = Flask(__name__)

@app.route('/report/<ticker>')
def daily_report(ticker):
    
    return render_template('report.html')

if __name__ == '__main__':
    app.run('0.0.0.0', port=8081, debug=True)