package hoo.stock_project.model.Service;

import java.util.List;

import hoo.stock_project.model.DTO.StockListDTO;

public interface StockListService {
    public StockListDTO getOneStock(String ticker);
    public List<StockListDTO> getAllStockOrderByTicker();
    public List<StockListDTO> getStockByContaining(String ticker);
    public void insertStock(StockListDTO dto);
    public void updateStock(StockListDTO dto);
    public void deleteStock(String ticker);
}
