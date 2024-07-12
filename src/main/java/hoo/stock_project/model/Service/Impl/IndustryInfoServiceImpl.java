package hoo.stock_project.model.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoo.stock_project.model.DAO.IndustryInfoDao;
import hoo.stock_project.model.DTO.IndustryInfoDTO;
import hoo.stock_project.model.Entity.IndustryInfoEntity;
import hoo.stock_project.model.Service.IndustryInfoService;

@Service
public class IndustryInfoServiceImpl implements IndustryInfoService{
    @Autowired
    private IndustryInfoDao industryInfoDao;

    @Override
    public void deleteIndustryInfo(Integer id) {
        // TODO Auto-generated method stub
        industryInfoDao.deleteIndustryInfo(id);
    }

    @Override
    public IndustryInfoDTO getOneIndustryInfo(String industry, String date) {
        // TODO Auto-generated method stub
        IndustryInfoEntity entity = industryInfoDao.getOneIndustryInfo(industry, date);
        IndustryInfoDTO dto = new IndustryInfoDTO();
        dto.setId(entity.getId());
        dto.setIndustry(entity.getIndustry());
        dto.setDate(entity.getDate());
        dto.setAvg_pct_change(entity.getAvg_pct_change());
        dto.setAvg_market_cap(entity.getAvg_market_cap());
        dto.setAvg_per(entity.getAvg_per());

        return dto;
    }

    @Override
    public void insertIndustryInfo(IndustryInfoDTO dto) {
        // TODO Auto-generated method stub
        IndustryInfoEntity entity = new IndustryInfoEntity();
        entity.setId(dto.getId());
        entity.setIndustry(dto.getIndustry());
        entity.setDate(dto.getDate());
        entity.setAvg_pct_change(dto.getAvg_pct_change());
        entity.setAvg_market_cap(dto.getAvg_market_cap());
        entity.setAvg_per(dto.getAvg_per());

        industryInfoDao.insertIndustryInfo(entity);
    }

    @Override
    public void updateIndustryInfo(IndustryInfoDTO dto) {
        // TODO Auto-generated method stub
        IndustryInfoEntity entity = industryInfoDao.getOneIndustryInfo(dto.getIndustry(), dto.getDate());
        entity.setAvg_pct_change(dto.getAvg_pct_change());
        entity.setAvg_market_cap(dto.getAvg_market_cap());
        entity.setAvg_per(dto.getAvg_per());

        industryInfoDao.updateIndustryInfo(entity);
    }

}
