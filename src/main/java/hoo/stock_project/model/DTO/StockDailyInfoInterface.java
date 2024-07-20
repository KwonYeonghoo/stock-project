package hoo.stock_project.model.DTO;

public interface StockDailyInfoInterface {
    String getTicker();
    String getName();
    String getIndustry();
    String getDate();
    Float getPrice();
    Long getVolume();
    Long getAvgVolume();
    Long getMarketCap();
    Float getPctChange();
    Float getDividendRate();
    Float getDividendYield();
    Float getPer();
}
