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


@Controller
@RequestMapping("/v1/stock/portfolio")
public class portfolioController {
    @Autowired
    private StockDailyInfoService stockDailyInfoService;
    @Autowired
    private PortfolioInfoService portfolioInfoService;
    @Autowired
    private StockListService stockListService;
    @Autowired
    private PortfolioStockInfoService portfolioStockInfoService;

    @GetMapping("/")
    public String getPortfolioPage(Model model){
        List<PortfolioInfoDTO> portfolios =  portfolioInfoService.getAllPortfolio();
        List<StockListDTO> stock_list = stockListService.getAllStockOrderByTicker();

        model.addAttribute("portfolios", portfolios);
        model.addAttribute("stock_list", stock_list);
        
        return "portfolio";
    }

    @PostMapping("/")
    public ResponseEntity<Void> addPortfolio(@RequestBody PortfolioInfoDTO dto) {
        String today = stockDailyInfoService.getMostRecentDate();
        dto.setDateCreated(today);
        portfolioInfoService.addPortfolio(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{ticker}")
    public ResponseEntity<Void> addStock(@PathVariable String ticker, @RequestBody PortfolioStockInfoDTO dto) {
        portfolioStockInfoService.addPortfolioStockInfo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
