document.addEventListener('DOMContentLoaded', () => {
    let currentPortfolioId = null;

    window.createPortfolioStockElement = function(currentPortfolioId) {
        if(!currentPortfolioId) {
            console.error('포트폴리오 ID를 찾을 수 없습니다!');
            return;
        }
        fetch(`/api/v1/stock/portfolio/${currentPortfolioId}`)
        .then(response => response.json())
        .then(data => {
            const formattedId = `portfolio${currentPortfolioId}`;
            window[formattedId] = data;
            const template = `
            {{#${formattedId}}}
            <li>
                <div class="item">
                    <div class="icon-box text-success">
                        <ion-icon name="trending-up-outline"></ion-icon>
                    </div>
                    <div class="in">
                        <div>
                            <strong>{{ticker}}</strong>
                            <div class="text-small text-secondary">{{name}}</div>
                        </div>
                        <div class="text-end">
                            <div class="text-end">
                                <strong>수량: {{amount}}</strong>
                            </div>
                            <strong>{{price}}</strong>
                            <div class="text-small">
                                <span class="badge badge-success">
                                    <ion-icon name="arrow-up-outline"></ion-icon>
                                    {{pct_change}}
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
            {{/${formattedId}}}
            `
            const rendered = Mustache.render(template, {
                [formattedId]: window[formattedId]
            });
            console.log("rendered: ", rendered);
            document.querySelector(`[data-portfolio-id="${currentPortfolioId}"]`).innerHTML = rendered;
        });
    };

    document.querySelectorAll('[data-portfolio-id]').forEach(
        container => {
            currentPortfolioId = parseInt(container.getAttribute('data-portfolio-id'), 10);
            createPortfolioStockElement(currentPortfolioId);
    });
});
