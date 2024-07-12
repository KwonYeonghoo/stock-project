package hoo.stock_project.model.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoo.stock_project.model.DAO.StockChartInfoDao;
import hoo.stock_project.model.DTO.StockChartInfoDTO;
import hoo.stock_project.model.Entity.StockChartInfoEntity;
import hoo.stock_project.model.Service.StockChartInfoService;

@Service
public class StockChartInfoServiceImpl implements StockChartInfoService{
    @Autowired
    private StockChartInfoDao stockChartInfoDao;

    @Override
    public void deleteStockChartInfo(Integer id) {
        // TODO Auto-generated method stub
        stockChartInfoDao.deleteStockChartInfo(id);
    }

    @Override
    public List<StockChartInfoDTO> getOneStockChartInfo(String ticker) {
        // TODO Auto-generated method stub
        List<StockChartInfoEntity> entities = stockChartInfoDao.getOneStockChartInfo(ticker);
        List<StockChartInfoDTO> dtos = new ArrayList<>();
        for(StockChartInfoEntity entity : entities) {
            StockChartInfoDTO dto = new StockChartInfoDTO();
            dto.setId(entity.getId());
            dto.setTicker(entity.getTicker());
            dto.setDate(entity.getDate());
            dto.setOpen_price(entity.getOpen_price());
            dto.setHigh_price(entity.getHigh_price());
            dto.setLow_price(entity.getLow_price());
            dto.setClose_price(entity.getClose_price());
            dto.setMa20(entity.getMa20());
            dto.setStd(entity.getStd());
            dto.setUpper(entity.getUpper());
            dto.setLower(entity.getLower());

            dtos.add(dto);
        }
        return dtos;
    }

    // @Override
    // public void insertStockChartInfo(stockChartInfoDTO dto) {
    //     // TODO Auto-generated method stub
    //     stockChartInfoEntity entity = new stockChartInfoEntity();
    //     entity.setId(dto.getId());
    //     entity.setTicker(dto.getTicker());
    //     entity.setDate(dto.getDate());
    //     entity.setOpen_price(dto.getOpen_price());
    //     entity.setHigh_price(dto.getHigh_price());
    //     entity.setLow_price(dto.getLow_price());
    //     entity.setClose_price(dto.getClose_price());
    //     entity.setMa20(dto.getMa20());
    //     entity.setStd(dto.getStd());
    //     entity.setUpper(dto.getUpper());
    //     entity.setLower(dto.getLower());

    //     stockChartInfoDao.insertStockChartInfo(entity);
    // }

    // @Override
    // public void updateStockChartInfo(stockChartInfoDTO dto) {
    //     // TODO Auto-generated method stub
    //     stockChartInfoEntity entity = stockChartInfoDao.getOneStockChartInfo(dto.getTicker());
    //     entity.setOpen_price(dto.getOpen_price());
    //     entity.setHigh_price(dto.getHigh_price());
    //     entity.setLow_price(dto.getLow_price());
    //     entity.setClose_price(dto.getClose_price());
    //     entity.setMa20(dto.getMa20());
    //     entity.setStd(dto.getStd());
    //     entity.setUpper(dto.getUpper());
    //     entity.setLower(dto.getLower());

    //     stockChartInfoDao.updateStockChartInfo(entity);
    // }

}
