package az.railway.service.impl;

import az.railway.dao.interf.PositionDao;
import az.railway.model.Position;
import az.railway.service.interf.PositionService;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    PositionDao positionDao;

    public PositionServiceImpl(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Override
    public List<Position> getPositionList() throws Exception {
        return positionDao.getPositionList();
    }

    @Override
    public void addPosition(Position position) throws Exception {
        positionDao.addPosition(position);
    }

    @Override
    public Position getPositionById(Long positionId) throws Exception {
        return positionDao.getPositionById(positionId);
    }

    @Override
    public void updatePosition(Position position) throws Exception {
        positionDao.updatePosition(position);
    }

    @Override
    public void deletePosition(Long positionId) throws Exception {
        positionDao.deletePosition(positionId);
    }

    @Override
    public List<Position> searchPosition(String keyword) throws Exception {
        return positionDao.searchPosition(keyword);
    }
}
