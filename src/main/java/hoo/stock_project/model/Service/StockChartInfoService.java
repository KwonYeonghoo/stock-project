package hoo.stock_project.model.Service;

import java.util.List;

import hoo.stock_project.model.DTO.StockChartInfoDTO;

public interface StockChartInfoService {
    public List<StockChartInfoDTO> getOneStockChartInfo(String ticker);
    // public void insertStockChartInfo(stockChartInfoDTO dto);
    // public void updateStockChartInfo(stockChartInfoDTO dto);
    public void deleteStockChartInfo(Integer id);
}
