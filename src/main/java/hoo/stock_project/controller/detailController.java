package hoo.stock_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hoo.stock_project.model.DTO.StockDailyInfoInterface;
import hoo.stock_project.model.DTO.StockNewsSummaryInterface;
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
        StockDailyInfoInterface stock_detail =  stockDailyInfoService.getStockDetail(ticker, today);
        List<StockNewsSummaryInterface> news_summaries = stockDailyInfoService.getAllNewsSummary(ticker, today);
        String volume = formatNumber(stock_detail.getVolume());
        String market_cap = formatNumber(stock_detail.getMarketCap());
        model.addAttribute("stock_detail", stock_detail);
        model.addAttribute("formattedVolume", volume);
        model.addAttribute("formattedMarketCap", market_cap);
        model.addAttribute("news_summaries", news_summaries);

        return "detail";
    }

    public static String formatNumber(long number) {
        double result;
        String unit;

        if (number >= 1_000_000_000_000L) {
            result = number / 1_000_000_000_000.0;
            unit = "조";
        } else if (number >= 1_000_000_000L) {
            result = number / 1_000_000_000.0;
            unit = "억";
        } else if (number >= 1_000_000L) {
            result = number / 1_000_000.0;
            unit = "백만";
        } else {
            result = number;
            unit = "";
        }

        return String.format("%.1f%s", result, unit);
    }
}
