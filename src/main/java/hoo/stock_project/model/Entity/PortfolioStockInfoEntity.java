package hoo.stock_project.model.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
@Entity(name = "portfolio_stock_info")
@Table(name = "portfolio_stock_info")
public class PortfolioStockInfoEntity {
    @EmbeddedId
    private PortfolioStockInfoPK portfolioStockInfoPK;
    private Integer amount;
}
