package hoo.stock_project.model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hoo.stock_project.model.Entity.StockChartInfoEntity;

public interface StockChartInfoRepository extends JpaRepository<StockChartInfoEntity, Integer>{
    @Query(value = "SELECT * FROM stock_chart_info WHERE ticker = :ticker ORDER BY ticker, date", nativeQuery = true)
    public List<StockChartInfoEntity> findByTicker(String ticker);
}
