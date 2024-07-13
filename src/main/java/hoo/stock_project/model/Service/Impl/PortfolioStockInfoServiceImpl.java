package hoo.stock_project.model.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoo.stock_project.model.DAO.PortfolioStockInfoDao;
import hoo.stock_project.model.DTO.PortfolioStockInfoDTO;
import hoo.stock_project.model.Entity.PortfolioStockInfoEntity;
import hoo.stock_project.model.Entity.PortfolioStockInfoPK;
import hoo.stock_project.model.Service.PortfolioStockInfoService;

@Service
public class PortfolioStockInfoServiceImpl implements PortfolioStockInfoService{
    @Autowired
    private PortfolioStockInfoDao portfolioStockInfoDao;

    @Override
    public List<PortfolioStockInfoDTO> getPortfolioStockInfo(Integer portfolioId) {
        // TODO Auto-generated method stub
        List<PortfolioStockInfoEntity> entities = portfolioStockInfoDao.getPortfolioStockInfo(portfolioId);
        List<PortfolioStockInfoDTO> dtos = new ArrayList<>();
        for (PortfolioStockInfoEntity entity : entities) {
            PortfolioStockInfoDTO dto = new PortfolioStockInfoDTO();
            dto.setPortfolioId(entity.getPortfolioStockInfoPK().getPortfolioId());
            dto.setTicker(entity.getPortfolioStockInfoPK().getTicker());
            dto.setAmount(entity.getAmount());

            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public void addPortfolioStockInfo(PortfolioStockInfoDTO dto) {
        // TODO Auto-generated method stub
        PortfolioStockInfoEntity entity = new PortfolioStockInfoEntity();
        PortfolioStockInfoPK pk = new PortfolioStockInfoPK();
        pk.setPortfolioId(dto.getPortfolioId());
        pk.setTicker(dto.getTicker());
        entity.setPortfolioStockInfoPK(pk);
        entity.setAmount(dto.getAmount());

        portfolioStockInfoDao.addPortfolioStockInfo(entity);
    }

}
