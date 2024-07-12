package hoo.stock_project.model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hoo.stock_project.model.Entity.StockDailyInfoEntity;
public interface StockDailyInfoRepository extends JpaRepository<StockDailyInfoEntity, Integer>{
    @Query(value = "SELECT * FROM stock_daily_info WHERE ticker = :ticker AND date = :date", nativeQuery = true)
    public List<StockDailyInfoEntity> findByTickerAndDate(@Param(value="ticker") String ticker, @Param(value="date") String date);

    @Query(value = "SELECT date FROM stock_daily_info ORDER BY date DESC LIMIT 1", nativeQuery = true)
    public String findMostRecentDate();
}
