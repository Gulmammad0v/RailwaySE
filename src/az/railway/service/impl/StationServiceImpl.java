package az.railway.service.impl;

import az.railway.dao.interf.StationDao;
import az.railway.model.Station;
import az.railway.service.interf.StationService;

import java.util.List;

public class StationServiceImpl implements StationService {
    StationDao stationDao;

    public StationServiceImpl(StationDao stationDao) {
        this.stationDao = stationDao;
    }

    @Override
    public List<Station> getStationList() throws Exception {
        return stationDao.getStationList();
    }

    @Override
    public void addStation(Station station) throws Exception {
        stationDao.addStation(station);
    }

    @Override
    public Station getStationById(Long stationId) throws Exception {
        return stationDao.getStationById(stationId);
    }

    @Override
    public void updateStation(Station station) throws Exception {
        stationDao.updateStation(station);
    }

    @Override
    public void deleteStation(Long stationId) throws Exception {
        stationDao.deleteStation(stationId);
    }

    @Override
    public List<Station> searchStationData(String keyword) throws Exception {
        return stationDao.searchStationData(keyword);
    }
}
