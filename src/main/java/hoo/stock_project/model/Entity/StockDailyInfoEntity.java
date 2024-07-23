package hoo.stock_project.model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "stock_daily_info")
@Table(name = "stock_daily_info")
public class StockDailyInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String ticker;
    @Column(nullable = false)
    private String date;
    private Float price;
    private Long volume;
    private Long avg_volume;
    private Float pct_change;
    private Long market_cap;
    private Float dividend_rate;
    private Float dividend_yield;
    private Float per;
    private String newsTitle;
    private String newsLink;
    private String newsThumbnail;

}
