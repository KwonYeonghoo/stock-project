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
public class StockChartInfoDTO {
    private Integer id;
    private String ticker;
    private Long date;
    private Float open_price;
    private Float high_price;
    private Float low_price;
    private Float close_price;
    private Float ma20;
    private Float std;
    private Float upper;
    private Float lower;
}
