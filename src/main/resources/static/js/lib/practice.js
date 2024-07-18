// document.addEventListener('DOMContentLoaded', () => {
//     let currentModalPortfolioId = null;
//     let currentTicker = null;

//     // 모달 트리거 버튼 클릭 시 포트폴리오 ID 저장
//     document.querySelectorAll('[data-bs-toggle="modal"]').forEach(button => {
//         button.addEventListener('click', function() {
//             currentModalPortfolioId = this.getAttribute('data-modal-portfolio-id');
//             currentTicker = this.getAttribute('data-modal-ticker');
//         });
//     });

//     // 종목 추가 함수
//     window.addStock = function() {
//         amount = document.getElementById("stockAmount").value;
//         const data = {
//             portfolioId: currentModalPortfolioId,
//             ticker: currentTicker,
//             amount: amount
//         };

//         fetch(`/v1/stock/portfolio/${currentModalPortfolioId}/${currentTicker}`, {
//             method: 'PUT',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify(data)
//         })
//         .then(response => {
//             if (response.status === 201) {
//                 alert('포트폴리오에 성공적으로 추가되었습니다!');
//             } else {
//                 alert('포트폴리오 추가에 실패하였습니다!');
//             }
//         })
//         .catch((error) => {
//             console.error('Error: ', error);
//         });
//     };
// });

