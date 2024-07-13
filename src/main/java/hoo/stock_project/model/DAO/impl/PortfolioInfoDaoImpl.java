package hoo.stock_project.model.DAO.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoo.stock_project.model.DAO.PortfolioInfoDao;
import hoo.stock_project.model.Entity.PortfolioInfoEntity;
import hoo.stock_project.model.Repository.PortfolioInfoRepository;

@Service
public class PortfolioInfoDaoImpl implements PortfolioInfoDao{
    @Autowired
    private PortfolioInfoRepository portfolioInfoRepository;

    @Override
    public PortfolioInfoEntity getPortfolio(Integer portfolioId) {
        // TODO Auto-generated method stub
        PortfolioInfoEntity entity = portfolioInfoRepository.findByPortfolioId(portfolioId);
        return entity;
    }
    
    @Override
    public List<PortfolioInfoEntity> getAllPortfolio() {
        // TODO Auto-generated method stub
        List<PortfolioInfoEntity> entities = portfolioInfoRepository.findAll();
        return entities;
    }

    @Override
    public void addPortfolio(PortfolioInfoEntity entity) {
        // TODO Auto-generated method stub
        portfolioInfoRepository.save(entity);
    }

}
