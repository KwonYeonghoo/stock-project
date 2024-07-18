package hoo.stock_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hoo.stock_project.model.DTO.PortfolioStockInterface;
import hoo.stock_project.model.DTO.StockListDTO;
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

    @Operation(summary = "종목 검색 시 검색어가 포함되는 종목 반환하는 메소드", description = "파라미터로 받은 글자를 포함하는 종목들을 모두 반환합니다.")
    @GetMapping("/search")
    public List<StockListDTO> searchTicker(@RequestParam String str) {
        List<StockListDTO> dtos = stockListService.getStockByContaining(str);
        return dtos;
    }

    @Operation(summary = "모든 종목 리스트를 반환하는 메소드", description = "검색창에서 문자 입력 전 모든 종목을 띄울 때 사용합니다.")
    @GetMapping("/search/all")
    public List<StockListDTO> getAllTickers() {
        List<StockListDTO> stock_list = stockListService.getAllStockOrderByTicker();
        return stock_list;
    }
}
