package hoo.stock_project.model.DAO.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoo.stock_project.model.DAO.StockDailyInfoDao;
import hoo.stock_project.model.Entity.StockDailyInfoEntity;
import hoo.stock_project.model.Repository.StockDailyInfoRepository;

@Service
public class StockDailyInfoDaoImpl implements StockDailyInfoDao{
    
    @Autowired
    private StockDailyInfoRepository stockDailyInfoRepository;

    @Override
    public List<StockDailyInfoEntity> getOneStockDailyInfo(String ticker, String date) {
        // TODO Auto-generated method stub
        List<StockDailyInfoEntity> entities = stockDailyInfoRepository.findByTickerAndDate(ticker, date);

        return entities;
    }

    @Override
    public void deleteStockDailyInfo(Integer id) {
        // TODO Auto-generated method stub
        stockDailyInfoRepository.deleteById(id);
    }

    @Override
    public void insertStockDailyInfo(StockDailyInfoEntity entity) {
        // TODO Auto-generated method stub
        stockDailyInfoRepository.save(entity);
    }

    @Override
    public void updateStockDailyInfo(StockDailyInfoEntity entity) {
        // TODO Auto-generated method stub
        stockDailyInfoRepository.save(entity);
    }

    @Override
    public String getMostRecentDate() {
        // TODO Auto-generated method stub
        String date = stockDailyInfoRepository.findMostRecentDate();
        return date;
    }

}
