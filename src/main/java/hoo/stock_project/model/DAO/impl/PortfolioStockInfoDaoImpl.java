package hoo.stock_project.model.DAO.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoo.stock_project.model.DAO.PortfolioStockInfoDao;
import hoo.stock_project.model.Entity.PortfolioStockInfoEntity;
import hoo.stock_project.model.Repository.PortfolioStockInfoRepository;

@Service
public class PortfolioStockInfoDaoImpl implements PortfolioStockInfoDao{
    @Autowired
    private PortfolioStockInfoRepository portfolioStockInfoRepository;

    @Override
    public List<PortfolioStockInfoEntity> getPortfolioStockInfo(Integer portfolioId) {
        // TODO Auto-generated method stub
        List<PortfolioStockInfoEntity> entities = portfolioStockInfoRepository.findAllByPortfolioStockInfoPKPortfolioId(portfolioId);
        return entities;
    }

    @Override
    public void addPortfolioStockInfo(PortfolioStockInfoEntity entity) {
        // TODO Auto-generated method stub
        portfolioStockInfoRepository.save(entity);
    }

    
}
