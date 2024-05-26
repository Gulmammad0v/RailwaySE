package az.railway.service.impl;

import az.railway.dao.interf.WagonDao;
import az.railway.model.Wagon;
import az.railway.service.interf.WagonService;

import java.util.List;

public class WagonServiceImpl implements WagonService {
    WagonDao wagonDao;

    public WagonServiceImpl(WagonDao wagonDao) {
        this.wagonDao = wagonDao;
    }

    @Override
    public List<Wagon> getWagonList() throws Exception {
        return wagonDao.getWagonList();
    }

    @Override
    public void addWagon(Wagon wagon) throws Exception {
        wagonDao.addWagon(wagon);
    }

    @Override
    public Wagon getWagonById(Long wagonId) throws Exception {
        return wagonDao.getWagonById(wagonId);
    }
}
