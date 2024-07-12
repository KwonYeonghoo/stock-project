package hoo.stock_project.model.DAO.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoo.stock_project.model.DAO.IndustryInfoDao;
import hoo.stock_project.model.Entity.IndustryInfoEntity;
import hoo.stock_project.model.Repository.IndustryInfoRepository;

@Service
public class IndustryInfoDaoImpl implements IndustryInfoDao{
    @Autowired
    private IndustryInfoRepository industryInfoRepository;

    @Override
    public IndustryInfoEntity getOneIndustryInfo(String industry, String date) {
        // TODO Auto-generated method stub
        IndustryInfoEntity entity = industryInfoRepository.findByIndustryAndDate(industry, date);
        return entity;
    }

    @Override
    public void deleteIndustryInfo(Integer id) {
        // TODO Auto-generated method stub
        industryInfoRepository.deleteById(id);
    }

    @Override
    public void insertIndustryInfo(IndustryInfoEntity entity) {
        // TODO Auto-generated method stub
        industryInfoRepository.save(entity);
    }

    @Override
    public void updateIndustryInfo(IndustryInfoEntity entity) {
        // TODO Auto-generated method stub
        industryInfoRepository.save(entity);
    }

    
}
