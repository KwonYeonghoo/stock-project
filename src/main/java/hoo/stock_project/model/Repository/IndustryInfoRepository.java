package hoo.stock_project.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hoo.stock_project.model.Entity.IndustryInfoEntity;

public interface IndustryInfoRepository extends JpaRepository<IndustryInfoEntity, Integer>{
    public IndustryInfoEntity findByIndustryAndDate(String industry, String date);
}
