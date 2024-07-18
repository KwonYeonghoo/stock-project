package hoo.stock_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import hoo.stock_project.model.DTO.PortfolioInfoDTO;
import hoo.stock_project.model.DTO.PortfolioStockInfoDTO;
import hoo.stock_project.model.DTO.StockListDTO;
import hoo.stock_project.model.Service.PortfolioInfoService;
import hoo.stock_project.model.Service.PortfolioStockInfoService;
import hoo.stock_project.model.Service.StockDailyInfoService;
import hoo.stock_project.model.Service.StockListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "PortfolioPage API", description = "개인별 포트폴리오를 조회할 수 있는 페이지를 좋회하는 API입니다.")
@Controller
@RequestMapping("/v1/stock/portfolio")
@Slf4j
public class portfolioController {
    @Autowired
    private StockDailyInfoService stockDailyInfoService;
    @Autowired
    private PortfolioInfoService portfolioInfoService;
    @Autowired
    private StockListService stockListService;
    @Autowired
    private PortfolioStockInfoService portfolioStockInfoService;

    @Operation(summary = "포트폴리오 페이지 조회", description = "포트폴리오 화면을 불러옵니다.")
    @GetMapping("/")
    public String getPortfolioPage(Model model){
        List<PortfolioInfoDTO> portfolios =  portfolioInfoService.getAllPortfolio();
        model.addAttribute("portfolios", portfolios);

        List<StockListDTO> stock_list = stockListService.getAllStockOrderByTicker();
        model.addAttribute("stock_list", stock_list);
        
        return "portfolio";
    }

    @Operation(summary = "포트폴리오를 추가하는 메소드", description = "Response Body로 넘겨받은 정보를 DB에 업데이트합니다.")
    @PostMapping("/")
    public ResponseEntity<Void> addPortfolio(@RequestBody PortfolioInfoDTO dto) {
        String today = stockDailyInfoService.getMostRecentDate();
        dto.setDateCreated(today);
        portfolioInfoService.addPortfolio(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "각 포트폴리오별로 종목을 추가하는 메소드", description = "portfolio_id와 ticker를 파라미터로 받으면 해당 포트폴리오에 종목을 추가합니다.")
    @PutMapping("/{portfolioId}/{ticker}")
    public ResponseEntity<Void> addPortfolioStock(@PathVariable Integer portfolioId, @PathVariable String ticker, @RequestBody PortfolioStockInfoDTO dto) {
        portfolioStockInfoService.addPortfolioStockInfo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
