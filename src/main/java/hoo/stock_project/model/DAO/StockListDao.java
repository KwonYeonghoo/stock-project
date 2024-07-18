package hoo.stock_project.model.DAO;

import java.util.List;

import hoo.stock_project.model.Entity.StockListEntity;
public interface StockListDao {
    public StockListEntity getOneStock(String ticker);
    public List<StockListEntity> getAllStockOrderByTicker();
    public List<StockListEntity> getStockByContaining(String ticker);
    public void insertStock(StockListEntity entity);
    public void updateStock(StockListEntity entity);
    public void deleteStock(String ticker);
}
