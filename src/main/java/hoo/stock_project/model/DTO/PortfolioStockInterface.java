package hoo.stock_project.model.DTO;

public interface PortfolioStockInterface {
    Integer getPortfolioId();
    String getTicker();
    Integer getAmount();
    String getName();
    Float getPrice();
    Float getPct_change();
}
