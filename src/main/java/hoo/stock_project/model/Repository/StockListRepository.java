package hoo.stock_project.model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hoo.stock_project.model.Entity.StockListEntity;
public interface StockListRepository extends JpaRepository<StockListEntity, String>{
    public StockListEntity findByTicker(String ticker);
    public List<StockListEntity> findAllByOrderByTicker();
    public List<StockListEntity> findByTickerContainingIgnoreCase(String ticker);
}
