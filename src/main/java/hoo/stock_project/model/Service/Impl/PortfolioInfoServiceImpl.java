package hoo.stock_project.model.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoo.stock_project.model.DAO.PortfolioInfoDao;
import hoo.stock_project.model.DTO.PortfolioInfoDTO;
import hoo.stock_project.model.Entity.PortfolioInfoEntity;
import hoo.stock_project.model.Service.PortfolioInfoService;

@Service
public class PortfolioInfoServiceImpl implements PortfolioInfoService{
    @Autowired
    private PortfolioInfoDao portfolioInfoDao;

    @Override
    public PortfolioInfoDTO getPortfolio(Integer portfolioId) {
        // TODO Auto-generated method stub
        PortfolioInfoEntity entity = portfolioInfoDao.getPortfolio(portfolioId);
        PortfolioInfoDTO dto = new PortfolioInfoDTO();
        dto.setPortfolioId(entity.getPortfolioId());
        dto.setPortfolioName(entity.getPortfolioName());
        dto.setDateCreated(entity.getDateCreated());
        dto.setPortfolioDetail(entity.getPortfolioDetail());

        return dto;
    }

    @Override
    public List<PortfolioInfoDTO> getAllPortfolio() {
        // TODO Auto-generated method stub
        List<PortfolioInfoEntity> entities = portfolioInfoDao.getAllPortfolio();
        List<PortfolioInfoDTO> dtos = new ArrayList<>();
        for (PortfolioInfoEntity entity : entities) {
            PortfolioInfoDTO dto = new PortfolioInfoDTO();
            dto.setPortfolioId(entity.getPortfolioId());
            dto.setPortfolioName(entity.getPortfolioName());
            dto.setPortfolioDetail(entity.getPortfolioDetail());
            dto.setDateCreated(entity.getDateCreated());

            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public void addPortfolio(PortfolioInfoDTO dto) {
        // TODO Auto-generated method stub
        PortfolioInfoEntity entity = new PortfolioInfoEntity();
        entity.setPortfolioId(dto.getPortfolioId());
        entity.setPortfolioName(dto.getPortfolioName());
        entity.setPortfolioDetail(dto.getPortfolioDetail());
        entity.setDateCreated(dto.getDateCreated());

        portfolioInfoDao.addPortfolio(entity);
    }

}
