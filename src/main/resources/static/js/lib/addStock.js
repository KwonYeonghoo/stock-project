function addStock(portfolioId, ticker) {
    const data = {
        portfolioId: portfolioId,
        ticker: ticker,
        amount: 100
    };

    fetch(`/v1/stock/portfolio/${ticker}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.status === 201) {
            alert('포트폴리오에 성공적으로 추가되었습니다!');
        } else {
            alert('포트폴리오 추가에 실패하였습니다!');
        }
    })
    .catch((error) => {
        console.error('Error: ', error);
    })
}