package hoo.stock_project.model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hoo.stock_project.model.DTO.PortfolioStockInterface;
import hoo.stock_project.model.Entity.PortfolioStockInfoEntity;
import hoo.stock_project.model.Entity.PortfolioStockInfoPK;

public interface PortfolioStockInfoRepository extends JpaRepository<PortfolioStockInfoEntity, PortfolioStockInfoPK>{
    public List<PortfolioStockInfoEntity> findAllByPortfolioStockInfoPKPortfolioId(Integer portfolioId);

    @Query(value="""
            WITH LatestStockInfo AS (
            SELECT sdi.ticker, sdi.price, sdi.pct_change, sdi.date,
                ROW_NUMBER() OVER (PARTITION BY sdi.ticker ORDER BY sdi.date DESC) as rn
            FROM stock_daily_info sdi
            )
            SELECT join1.portfolio_id, join1.ticker, join1.amount, join1.name, LatestStockInfo.price, LatestStockInfo.pct_change
            FROM (
                SELECT psi.portfolio_id, psi.ticker, psi.amount, sl.name
                FROM portfolio_stock_info psi 
                JOIN stock_list sl ON psi.ticker = sl.ticker
            ) join1 
            JOIN LatestStockInfo ON join1.ticker = LatestStockInfo.ticker
            WHERE LatestStockInfo.rn = 1 AND join1.portfolio_id = :portfolio_id
            """, nativeQuery=true)
    public List<PortfolioStockInterface> findEachPortfolioStock(@Param(value="portfolio_id") Integer portfolio_id);
}
