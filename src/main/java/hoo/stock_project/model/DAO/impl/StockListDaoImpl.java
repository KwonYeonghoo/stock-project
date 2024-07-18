package hoo.stock_project.model.DAO.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoo.stock_project.model.DAO.StockListDao;
import hoo.stock_project.model.Entity.StockListEntity;
import hoo.stock_project.model.Repository.StockListRepository;

@Service
public class StockListDaoImpl implements StockListDao{

    @Autowired
    private StockListRepository stockListRepository;

    @Override
    public StockListEntity getOneStock(String ticker) {
        // TODO Auto-generated method stub
        StockListEntity entity = stockListRepository.findByTicker(ticker);
        return entity;
    }

    @Override
    public List<StockListEntity> getAllStockOrderByTicker() {
        // TODO Auto-generated method stub
        List<StockListEntity> entities = stockListRepository.findAllByOrderByTicker();
        return entities;
    }

    @Override
    public List<StockListEntity> getStockByContaining(String ticker) {
        // TODO Auto-generated method stub
        List<StockListEntity> entities = stockListRepository.findByTickerContainingIgnoreCase(ticker);
        return entities;
    }

    @Override
    public void deleteStock(String ticker) {
        // TODO Auto-generated method stub
        stockListRepository.deleteById(ticker);
    }

    @Override
    public void insertStock(StockListEntity entity) {
        // TODO Auto-generated method stub
        stockListRepository.save(entity);
    }

    @Override
    public void updateStock(StockListEntity entity) {
        // TODO Auto-generated method stub
        stockListRepository.save(entity);
    }
    
    
}
