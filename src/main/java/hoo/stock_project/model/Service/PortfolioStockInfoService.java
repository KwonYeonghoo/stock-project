package hoo.stock_project.model.Service;

import java.util.List;

import hoo.stock_project.model.DTO.PortfolioStockInfoDTO;

public interface PortfolioStockInfoService {
    public List<PortfolioStockInfoDTO> getPortfolioStockInfo(Integer portfolioId);
    public void addPortfolioStockInfo(PortfolioStockInfoDTO dto);
}
