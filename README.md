# 나스닥 프로젝트 디벨롭
## 개발일지
- **7/7 docker MySQL 서버 구축**
    - Dockerfile로 커스텀 MySQL 이미지 생성
        - 필요한 환경변수들을 미리 선언
        - db초기화 스크립트 Docker컨테이너에 복사
    - Docker-compose 사용하여 MySQL 컨테이너 생성
        - 호스트 시스템에 MySQL컨테이너 내의 데이터 저장소 마운트
- **7/8 DB스키마 생성 및 ERD 구상**
    - DBeaver로 테이블 생성 스크립트 작성 후 ERD 구상
- **7/9 데이터수집 코드 작성**
    - jupyter notebook 환경에서 데이터수집 코드 작성
    - 후에 Airflow로 자동화시킬 예정
- **7/10 Flask서버 구축 PoC & Gemini 일간 리포트 생성**
    - Google Gemini를 사용하여 일간 리포트를 생성
        - SpringBoot보다는 파이썬 기반의 웹프레임워크인 Flask가 낫겠다는 판단
- **7/12 종목상세 페이지 백엔드 구현(SpringBoot)**
    - SpringBoot로 백엔드 작업
- **7/13 포트폴리오 페이지 초안**
    - SpringBoot로 백엔드 작업
    - 포트폴리오 그룹 생성
        - 각 포트폴리오별 종목 추가 기능은 실패
- **7/14 포트폴리오별 종목 추가 기능**
    - 각 포트폴리오별로 종목을 추가하려고 할 때, portfolio_id가 1번인 포트폴리오에만 종목이 추가되는 오류 해결
        - 각 포트폴리오별로 종목을 추가하는 모달창을 띄울 때 portfolio_id값이 함께 넘어오지 않아서 발생했던 문제
            - html 태그에 `data-modal-portfolio-id="{{portfolioId}}”` 속성 추가
            - js로 `data-modal-portfolio-id` 의 값을 받아오는 방법으로 해결
                
                ```
                document.addEventListener('DOMContentLoaded', () => {
                    let currentModalPortfolioId = null;
                
                    // 모달 트리거 버튼 클릭 시 포트폴리오 ID 저장
                    document.querySelectorAll('[data-bs-toggle="modal"]').forEach(button => {
                        button.addEventListener('click', function() {
                            currentModalPortfolioId = this.getAttribute('data-modal-portfolio-id');
                        });
                    });
                ```
                
    - 각 포트폴리오별 종목리스트를 Mustache객체로 추가하는 과정에서 하루정도 막혀있었음
        - 컨트롤러에서 기존에 썼던 `model.addAttrubute()` 방식으로는 해결이 안돼서 js로 Mustache 템플릿 렌더링하는 방식 찾아냄
            - Mustache.js 파일 불러오기
                
                `<script src="https://cdn.jsdelivr.net/npm/mustache@4.2.0/mustache.min.js"></script>`
                
            - 포트폴리오별 개별종목을 REST API를 통해 JSON으로 리턴
                
                ```jsx
                fetch(`/api/v1/stock/portfolio/${currentPortfolioId}`)
                        .then(response => response.json())
                        .then(data => { ... })
                ```
                
            - **중요!!** window객체에 전역변수 선언
                
                Key: Mustache객체의 key값
                
                Value: 저장할 데이터
                
                ```jsx
                // formattedId가 각 포트폴리오별 종목리스트 객체의 Key값
                const formattedId = `portfolio${currentPortfolioId}`;
                window[formattedId] = data;
                ```
                
            - 그러면 아래와 같이 Mustache 템플릿 렌더링이 js에서 가능해짐
                
                ```jsx
                const template = `
                  {{#${formattedId}}}
                  <li>
                      {{ticker}}
                      ...
                  </li>
                  {{/${formattedId}}}
                  `
                  const rendered = Mustache.render(template, {
                      [formattedId]: window[formattedId]
                  });
                  console.log("rendered: ", rendered);
                  document.querySelector(`[data-portfolio-id="${currentPortfolioId}"]`).innerHTML = rendered;
                ```
