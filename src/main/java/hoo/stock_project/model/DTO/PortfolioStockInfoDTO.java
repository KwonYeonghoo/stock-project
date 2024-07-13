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
public class PortfolioStockInfoDTO {
    private Integer portfolioId;
    private String ticker;
    private Integer amount;
}
