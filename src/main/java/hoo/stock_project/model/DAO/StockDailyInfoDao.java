package hoo.stock_project.model.DAO;

import java.util.List;

import hoo.stock_project.model.Entity.StockDailyInfoEntity;

public interface StockDailyInfoDao {
    public List<StockDailyInfoEntity> getOneStockDailyInfo(String ticker, String date);
    public void insertStockDailyInfo(StockDailyInfoEntity entity);
    public void updateStockDailyInfo(StockDailyInfoEntity entity);
    public void deleteStockDailyInfo(Integer id);

    public String getMostRecentDate();
}
