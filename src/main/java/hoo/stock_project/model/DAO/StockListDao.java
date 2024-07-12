package hoo.stock_project.model.DAO;

import hoo.stock_project.model.Entity.StockListEntity;
public interface StockListDao {
    public StockListEntity getOneStock(String ticker);
    public void insertStock(StockListEntity entity);
    public void updateStock(StockListEntity entity);
    public void deleteStock(String ticker);
}
