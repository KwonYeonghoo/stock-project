document.getElementById('searchTicker').addEventListener('input', function() {
    const query = this.value;
    let stockListTemplate = `
    {{#stockList}}
    <div class="col-6 mb-2">
        <div class="bill-box">
            <div class="img-wrapper">
                <img src="/img/logo/{{ticker}}.png" alt="img" class="image-block imaged w48">
            </div>
            <div class="price" id="Ticker">{{ticker}}</div>
            <p>{{name}}</p>
            <button type=“button” class="btn btn-primary btn-block btn-sm" data-bs-toggle="modal" data-bs-target="#AmountInput" data-modal-ticker="{{ticker}}">추가</button>
        </div>
    </div>
    {{/stockList}}
    `;
    if (query.length > 0) { // 최소 1글자 이상 입력 시 요청
        fetch(`/api/v1/stock/search?str=${query}`)
            .then(response => response.json())
            .then(data => {
                window["stockList"] = data;
                const stockListRender = Mustache.render(stockListTemplate, {
                    stockList: window.stockList
                });
                document.getElementById('stockListContainer').innerHTML = stockListRender;
            });
            
    } else {
        fetch("/api/v1/stock/search/all")
        .then(response => response.json())
        .then(data => {
            window["stockList"] = data
            const stockListRender = Mustache.render(stockListTemplate, {
                stockList: window.stockList
            });
            document.getElementById('stockListContainer').innerHTML = stockListRender;
        });
    }
});
