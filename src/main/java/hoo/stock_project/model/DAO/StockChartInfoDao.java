package hoo.stock_project.model.DAO;

import java.util.List;

import hoo.stock_project.model.Entity.StockChartInfoEntity;

public interface StockChartInfoDao {
    public List<StockChartInfoEntity> getOneStockChartInfo(String ticker);
    public void insertStockChartInfo(StockChartInfoEntity entity);
    public void updateStockChartInfo(StockChartInfoEntity entity);
    public void deleteStockChartInfo(Integer id);
}
