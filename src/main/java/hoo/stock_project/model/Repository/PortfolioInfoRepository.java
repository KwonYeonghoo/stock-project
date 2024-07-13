package hoo.stock_project.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hoo.stock_project.model.Entity.PortfolioInfoEntity;

public interface PortfolioInfoRepository extends JpaRepository<PortfolioInfoEntity, Integer>{
    public PortfolioInfoEntity findByPortfolioId(Integer portfolioId);
}
