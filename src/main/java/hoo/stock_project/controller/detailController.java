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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name="DetailPage API", description = "종목별 상세정보 페이지를 조회하는 API입니다.")
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

    @Operation(summary = "종목별 상세페이지를 조회", description = "파라미터로 받은 종목의 상세정보를 조회합니다.")
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
