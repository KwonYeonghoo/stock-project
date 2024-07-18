package hoo.stock_project.model.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoo.stock_project.model.DAO.StockListDao;
import hoo.stock_project.model.DTO.StockListDTO;
import hoo.stock_project.model.Entity.StockListEntity;
import hoo.stock_project.model.Service.StockListService;

@Service
public class StockListServiceImpl implements StockListService{
    @Autowired
    private StockListDao stockListDao;

    @Override
    public void deleteStock(String ticker) {
        // TODO Auto-generated method stub
        stockListDao.deleteStock(ticker);
    }

    @Override
    public StockListDTO getOneStock(String ticker) {
        // TODO Auto-generated method stub
        StockListEntity entity = stockListDao.getOneStock(ticker);
        StockListDTO dto = new StockListDTO();

        dto.setTicker(entity.getTicker());
        dto.setName(entity.getName());
        dto.setIndustry(entity.getIndustry());

        return dto;
    }

    @Override
    public List<StockListDTO> getAllStockOrderByTicker() {
        // TODO Auto-generated method stub
        List<StockListEntity> entities = stockListDao.getAllStockOrderByTicker();
        List<StockListDTO> dtos = new ArrayList<>();
        for (StockListEntity entity : entities) {
            StockListDTO dto = new StockListDTO();
            dto.setTicker(entity.getTicker());
            dto.setName(entity.getName());
            dto.setIndustry(entity.getIndustry());

            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public List<StockListDTO> getStockByContaining(String ticker) {
        // TODO Auto-generated method stub
        List<StockListEntity> entities = stockListDao.getStockByContaining(ticker);
        List<StockListDTO> dtos = new ArrayList<>();
        for (StockListEntity entity : entities) {
            StockListDTO dto = new StockListDTO();
            dto.setTicker(entity.getTicker());
            dto.setName(entity.getName());
            dto.setIndustry(entity.getIndustry());

            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public void insertStock(StockListDTO dto) {
        // TODO Auto-generated method stub
        StockListEntity entity = new StockListEntity();
        entity.setTicker(dto.getTicker());
        entity.setName(dto.getName());
        entity.setIndustry(dto.getIndustry());

        stockListDao.insertStock(entity);
    }

    @Override
    public void updateStock(StockListDTO dto) {
        // TODO Auto-generated method stub
        StockListEntity entity = stockListDao.getOneStock(dto.getTicker());
        entity.setName(dto.getName());
        entity.setIndustry(dto.getIndustry());

        stockListDao.updateStock(entity);
    }

}
