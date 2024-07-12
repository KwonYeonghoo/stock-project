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
public class IndustryInfoDTO {
    private Integer id;
    private String industry;
    private String date;
    private Float avg_market_cap;
    private Float avg_per;
    private Float avg_pct_change;
}
