package az.railway.service.impl;

import az.railway.dao.interf.DirectionDao;
import az.railway.model.Direction;
import az.railway.service.interf.DirectionService;

import java.util.List;

public class DirectionServiceImpl implements DirectionService {
    DirectionDao directionDao;

    public DirectionServiceImpl(DirectionDao directionDao) {
        this.directionDao = directionDao;
    }

    @Override
    public List<Direction> getDirectionList() throws Exception {
        return directionDao.getDirectionList();
    }
}
