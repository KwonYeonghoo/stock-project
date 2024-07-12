package hoo.stock_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hoo.stock_project.model.DTO.StockListDTO;
import hoo.stock_project.model.Service.StockDailyInfoService;
import hoo.stock_project.model.Service.StockListService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/v1/stock/detail")
@Controller
public class detailController {
    @Autowired
    private StockListService stockListService;
    @Autowired
    private StockDailyInfoService stockDailyInfoService;
    // @Autowired
    // private StockChartInfoService stockChartInfoService;
    // @Autowired
    // private IndustryInfoService industryInfoService;

    @GetMapping("/{ticker}")
    public String getDetailPage(@PathVariable String ticker, Model model){
        String today = stockDailyInfoService.getMostRecentDate();
        StockListDTO stock_list = stockListService.getOneStock(ticker);
        // List<stockDailyInfoDTO> stock_daily_info =  stockDailyInfoService.getOneStockDailyInfo(ticker, today);
        // List<stockChartInfoDTO> stock_chart_info = stockChartInfoService.getOneStockChartInfo(ticker);
        // industryInfoDTO industry_info = industryInfoService.getOneIndustryInfo(stock_list.getIndustry(), today);

        model.addAttribute("today", today);
        model.addAttribute("ticker", stock_list.getTicker());
        model.addAttribute("name", stock_list.getName());
        model.addAttribute("industry", stock_list.getIndustry());

        return "detail";
    }
}
