package hoo.stock_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hoo.stock_project.model.DTO.PortfolioStockInfoDTO;
import hoo.stock_project.model.Service.PortfolioInfoService;
import hoo.stock_project.model.Service.PortfolioStockInfoService;
import hoo.stock_project.model.Service.StockListService;

@RequestMapping("/api/v1/stock")
@RestController
public class restController {
    @Autowired
    private PortfolioInfoService portfolioInfoService;
    @Autowired
    private PortfolioStockInfoService portfolioStockInfoService;
    @Autowired
    private StockListService stockListService;

    @GetMapping("/portfolio/{portfolioId}")
    public List<PortfolioStockInfoDTO> getPortfolioStockInfo(@PathVariable Integer portfolioId) {
        List<PortfolioStockInfoDTO> dtos =  portfolioStockInfoService.getPortfolioStockInfo(portfolioId);
        return dtos;
    }
}
