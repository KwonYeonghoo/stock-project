package hoo.stock_project.model.DAO;

import java.util.List;

import hoo.stock_project.model.Entity.PortfolioInfoEntity;

public interface PortfolioInfoDao {
    public PortfolioInfoEntity getPortfolio(Integer portfolioId);
    public List<PortfolioInfoEntity> getAllPortfolio();
    public void addPortfolio(PortfolioInfoEntity entity);
}
