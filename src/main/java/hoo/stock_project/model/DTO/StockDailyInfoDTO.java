package hoo.stock_project.model.DTO;

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
public class StockDailyInfoDTO {
    private Integer id;
    private String ticker;
    private String date;
    private Float price;
    private Long volumne;
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
