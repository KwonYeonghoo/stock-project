package hoo.stock_project.model.DAO;

import hoo.stock_project.model.Entity.IndustryInfoEntity;

public interface IndustryInfoDao {
    public IndustryInfoEntity getOneIndustryInfo(String industry, String date);
    public void insertIndustryInfo(IndustryInfoEntity entity);
    public void updateIndustryInfo(IndustryInfoEntity entity);
    public void deleteIndustryInfo(Integer id);
}
