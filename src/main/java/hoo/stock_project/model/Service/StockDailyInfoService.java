package hoo.stock_project.model.Service;

import java.util.List;

import hoo.stock_project.model.DTO.StockDailyInfoDTO;
import hoo.stock_project.model.DTO.StockDailyInfoInterface;
import hoo.stock_project.model.DTO.StockNewsSummaryInterface;

public interface StockDailyInfoService {
    public List<StockDailyInfoDTO> getOneStockDailyInfo(String ticker, String date);
    // public void insertStockDailyInfo(stockDailyInfoDTO dto);
    // public void updateStockDailyInfo(stockDailyInfoDTO dto);
    public void deleteStockDailyInfo(Integer id);

    public String getMostRecentDate();

    public StockDailyInfoInterface getStockDetail(String ticker, String date);
    public List<StockNewsSummaryInterface> getAllNewsSummary(String ticker, String date);
}
