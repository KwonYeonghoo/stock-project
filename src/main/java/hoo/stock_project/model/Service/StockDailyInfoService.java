package hoo.stock_project.model.Service;

import java.util.List;

import hoo.stock_project.model.DTO.StockDailyInfoDTO;

public interface StockDailyInfoService {
    public List<StockDailyInfoDTO> getOneStockDailyInfo(String ticker, String date);
    // public void insertStockDailyInfo(stockDailyInfoDTO dto);
    // public void updateStockDailyInfo(stockDailyInfoDTO dto);
    public void deleteStockDailyInfo(Integer id);

    public String getMostRecentDate();
}
