package hoo.stock_project.model.Service;

import java.util.List;

import hoo.stock_project.model.DTO.PortfolioStockInfoDTO;
import hoo.stock_project.model.DTO.PortfolioStockInterface;

public interface PortfolioStockInfoService {
    public List<PortfolioStockInfoDTO> getPortfolioStockInfo(Integer portfolioId);
    public void addPortfolioStockInfo(PortfolioStockInfoDTO dto);
    public List<PortfolioStockInterface> getEachPortfolioStock(Integer portfolio_id);
}
