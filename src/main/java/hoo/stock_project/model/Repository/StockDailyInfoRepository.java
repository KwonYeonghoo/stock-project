package hoo.stock_project.model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hoo.stock_project.model.DTO.StockDailyInfoInterface;
import hoo.stock_project.model.DTO.StockNewsInterface;
import hoo.stock_project.model.Entity.StockDailyInfoEntity;
public interface StockDailyInfoRepository extends JpaRepository<StockDailyInfoEntity, Integer>{
    @Query(value = "SELECT * FROM stock_daily_info WHERE ticker = :ticker AND date = :date", nativeQuery = true)
    public List<StockDailyInfoEntity> findByTickerAndDate(@Param(value="ticker") String ticker, @Param(value="date") String date);

    @Query(value = "SELECT date FROM stock_daily_info ORDER BY date DESC LIMIT 1", nativeQuery = true)
    public String findMostRecentDate();

    @Query(value="""
            WITH stock_detail AS (
                SELECT
                    sdi.ticker,
                    sdi.date,
                    sl.name,
                    sl.industry,
                    sdi.price,
                    sdi.pct_change,
                    sdi.volume,
                    sdi.avg_volume,
                    sdi.market_cap,
                    sdi.per,
                    sdi.dividend_rate,
                    sdi.dividend_yield,
                    ROW_NUMBER() OVER (PARTITION BY sdi.ticker ORDER BY sdi.date DESC) AS rn
                FROM stock_daily_info sdi
                    JOIN stock_list sl
                    ON sdi.ticker = sl.ticker
                WHERE sdi.ticker = :ticker AND sdi.date = :today
            )
            SELECT
                ticker,
                date,
                name,
                industry,
                price,
                pct_change,
                volume,
                avg_volume,
                market_cap,
                per,
                dividend_rate,
                dividend_yield
            FROM
                stock_detail
            WHERE rn = 1;
            """, nativeQuery=true)
    public StockDailyInfoInterface findStockDetail(@Param(value = "ticker") String ticker, @Param(value = "today") String date);
    
    @Query(value = """
            SELECT news_title, news_link, news_thumbnail
            FROM stock_daily_info
            WHERE ticker = :ticker AND date = :date
            """, nativeQuery=true)
    public List<StockNewsInterface> findAllNews(@Param(value = "ticker") String ticker, @Param(value = "date") String date);
}
