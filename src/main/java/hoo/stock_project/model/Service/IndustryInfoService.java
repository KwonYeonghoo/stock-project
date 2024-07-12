package hoo.stock_project.model.Service;

import hoo.stock_project.model.DTO.IndustryInfoDTO;

public interface IndustryInfoService {
    public IndustryInfoDTO getOneIndustryInfo(String industry, String date);
    public void insertIndustryInfo(IndustryInfoDTO dto);
    public void updateIndustryInfo(IndustryInfoDTO dto);
    public void deleteIndustryInfo(Integer id);
}
