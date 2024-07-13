package hoo.stock_project.model.Service;

import java.util.List;

import hoo.stock_project.model.DTO.PortfolioInfoDTO;

public interface PortfolioInfoService {
    public PortfolioInfoDTO getPortfolio(Integer portfolioId);
    public List<PortfolioInfoDTO> getAllPortfolio();
    public void addPortfolio(PortfolioInfoDTO dto);
}
