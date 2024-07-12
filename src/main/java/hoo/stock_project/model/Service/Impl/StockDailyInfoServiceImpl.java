package hoo.stock_project.model.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoo.stock_project.model.DAO.StockDailyInfoDao;
import hoo.stock_project.model.DTO.StockDailyInfoDTO;
import hoo.stock_project.model.Entity.StockDailyInfoEntity;
import hoo.stock_project.model.Service.StockDailyInfoService;

@Service
public class StockDailyInfoServiceImpl implements StockDailyInfoService{
    @Autowired
    private StockDailyInfoDao stockDailyInfoDao;

    @Override
    public void deleteStockDailyInfo(Integer id) {
        // TODO Auto-generated method stub
        stockDailyInfoDao.deleteStockDailyInfo(id);
    }

    @Override
    public List<StockDailyInfoDTO> getOneStockDailyInfo(String ticker, String date) {
        // TODO Auto-generated method stub
        List<StockDailyInfoEntity> entities = stockDailyInfoDao.getOneStockDailyInfo(ticker, date);
        List<StockDailyInfoDTO> dtos = new ArrayList<>();
        for(StockDailyInfoEntity entity : entities) {
            StockDailyInfoDTO dto = new StockDailyInfoDTO();
            dto.setId(entity.getId());
            dto.setTicker(entity.getTicker());
            dto.setDate(entity.getDate());
            dto.setPrice(entity.getPrice());
            dto.setPct_change(entity.getPct_change());
            dto.setMarket_cap(entity.getMarket_cap());
            dto.setVolumne(entity.getVolumne());
            dto.setAvg_volume(entity.getAvg_volume());
            dto.setPer(entity.getPer());
            dto.setDividend_rate(entity.getDividend_rate());
            dto.setDividend_yield(entity.getDividend_yield());
            dto.setNews_summary(entity.getNews_summary());

            dtos.add(dto);
        }
        return dtos;
    }

    // @Override
    // public void insertStockDailyInfo(stockDailyInfoDTO dto) {
    //     // TODO Auto-generated method stub
    //     stockDailyInfoEntity entity = new stockDailyInfoEntity();
    //     entity.setId(dto.getId());
    //     entity.setTicker(dto.getTicker());
    //     entity.setDate(dto.getDate());
    //     entity.setPrice(dto.getPrice());
    //     entity.setPct_change(dto.getPct_change());
    //     entity.setMarket_cap(dto.getMarket_cap());
    //     entity.setVolumne(dto.getVolumne());
    //     entity.setAvg_volume(dto.getAvg_volume());
    //     entity.setPer(dto.getPer());
    //     entity.setDividend_rate(dto.getDividend_rate());
    //     entity.setDividend_yield(dto.getDividend_yield());
    //     entity.setNews_summary(dto.getNews_summary());

    //     stockDailyInfoDao.insertStockDailyInfo(entity);
    // }

    // @Override
    // public void updateStockDailyInfo(stockDailyInfoDTO dto) {
    //     // TODO Auto-generated method stub
    //     stockDailyInfoEntity entity = stockDailyInfoDao.getOneStockDailyInfo(dto.getTicker(), dto.getDate());
    //     entity.setDate(dto.getDate());
    //     entity.setPrice(dto.getPrice());
    //     entity.setPct_change(dto.getPct_change());
    //     entity.setMarket_cap(dto.getMarket_cap());
    //     entity.setVolumne(dto.getVolumne());
    //     entity.setAvg_volume(dto.getAvg_volume());
    //     entity.setPer(dto.getPer());
    //     entity.setDividend_rate(dto.getDividend_rate());
    //     entity.setDividend_yield(dto.getDividend_yield());
    //     entity.setNews_summary(dto.getNews_summary());

    //     stockDailyInfoDao.updateStockDailyInfo(entity);
    // }

    @Override
    public String getMostRecentDate() {
        // TODO Auto-generated method stub
        String date = stockDailyInfoDao.getMostRecentDate();
        return date;
    }

}
