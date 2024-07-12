package hoo.stock_project.model.DAO.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoo.stock_project.model.DAO.StockChartInfoDao;
import hoo.stock_project.model.Entity.StockChartInfoEntity;
import hoo.stock_project.model.Repository.StockChartInfoRepository;

@Service
public class StockChartInfoDaoImpl implements StockChartInfoDao{
    @Autowired
    private StockChartInfoRepository stockChartInfoRepository;

    @Override
    public List<StockChartInfoEntity> getOneStockChartInfo(String ticker) {
        // TODO Auto-generated method stub
        List<StockChartInfoEntity> entities = stockChartInfoRepository.findByTicker(ticker);
        return entities;
    }

    @Override
    public void deleteStockChartInfo(Integer id) {
        // TODO Auto-generated method stub
        stockChartInfoRepository.deleteById(id);
    }

    @Override
    public void insertStockChartInfo(StockChartInfoEntity entity) {
        // TODO Auto-generated method stub
        stockChartInfoRepository.save(entity);
    }

    @Override
    public void updateStockChartInfo(StockChartInfoEntity entity) {
        // TODO Auto-generated method stub
        stockChartInfoRepository.save(entity);
    }
}
