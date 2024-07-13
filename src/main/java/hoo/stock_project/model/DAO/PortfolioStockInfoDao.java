package hoo.stock_project.model.DAO;

import java.util.List;

import hoo.stock_project.model.Entity.PortfolioStockInfoEntity;

public interface PortfolioStockInfoDao {
    public List<PortfolioStockInfoEntity> getPortfolioStockInfo(Integer portfolioId);
    public void addPortfolioStockInfo(PortfolioStockInfoEntity entity);
}
