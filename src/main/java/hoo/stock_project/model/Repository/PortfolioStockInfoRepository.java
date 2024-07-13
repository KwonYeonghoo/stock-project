package hoo.stock_project.model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hoo.stock_project.model.Entity.PortfolioStockInfoEntity;
import hoo.stock_project.model.Entity.PortfolioStockInfoPK;

public interface PortfolioStockInfoRepository extends JpaRepository<PortfolioStockInfoEntity, PortfolioStockInfoPK>{
    public List<PortfolioStockInfoEntity> findAllByPortfolioStockInfoPKPortfolioId(Integer portfolioId);
}
