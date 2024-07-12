package hoo.stock_project.model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hoo.stock_project.model.Entity.StockChartInfoEntity;

public interface StockChartInfoRepository extends JpaRepository<StockChartInfoEntity, Integer>{
    public List<StockChartInfoEntity> findByTicker(String ticker);
}
