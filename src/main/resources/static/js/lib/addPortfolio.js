function submitForm() {
    const portfolioName = document.getElementById('portfolioName').value;
    const portfolioDetail = document.getElementById('portfolioDetail').value;

    const data = {
        portfolioName: portfolioName,
        portfolioDetail: portfolioDetail
    };

    fetch('/v1/stock/portfolio/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.status === 201) {
            alert('포트폴리오가 성공적으로 추가되었습니다!');
            document.getElementById('portfolioForm').reset();
            location.reload();
        } else {
            alert('포트폴리오 추가에 실패하였습니다!');
        }
    })
    .catch((error) => {
        console.error('Error:', error);
    })
}