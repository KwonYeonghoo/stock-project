package hoo.stock_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hoo.stock_project.model.DTO.PortfolioStockInterface;
import hoo.stock_project.model.Service.PortfolioInfoService;
import hoo.stock_project.model.Service.PortfolioStockInfoService;
import hoo.stock_project.model.Service.StockListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "REST API", description = "JSON으로 정보를 받아와야할 때 사용하는 API입니다.")
@RequestMapping("/api/v1/stock")
@RestController
public class restController {
    @Autowired
    private PortfolioInfoService portfolioInfoService;
    @Autowired
    private PortfolioStockInfoService portfolioStockInfoService;
    @Autowired
    private StockListService stockListService;

    @Operation(summary = "포트폴리오별 구성 종목 조회하는 메소드", description = "파라미터로 받은 portfolio_id에 해당하는 포트폴리오의 구성종목을 JSON으로 리턴합니다.")
    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioStockInterface> getPortfolioStockInfo(@PathVariable Integer portfolioId) {
        List<PortfolioStockInterface> portfolioStocks = portfolioStockInfoService.getEachPortfolioStock(portfolioId);
        return portfolioStocks;
    }
}
