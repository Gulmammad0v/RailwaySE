package az.railway.service.impl;

import az.railway.dao.interf.TrainTimeStationDao;
import az.railway.model.TrainTimeStation;
import az.railway.service.interf.TrainTimeStationService;

import java.util.List;

public class TrainTimeStationServiceImpl implements TrainTimeStationService {
    TrainTimeStationDao trainTimeStationDao;

    public TrainTimeStationServiceImpl(TrainTimeStationDao trainTimeStationDao) {
        this.trainTimeStationDao = trainTimeStationDao;
    }

    @Override
    public List<TrainTimeStation> getTrainTimeStationList() throws Exception {
        return trainTimeStationDao.getTrainTimeStationList();
    }

    @Override
    public void addTrainTimeStation(TrainTimeStation trainTimeStation) throws Exception {
        trainTimeStationDao.addTrainTimeStation(trainTimeStation);
    }

    @Override
    public TrainTimeStation getTrainTimeStationById(Long trainTimeStationId) throws Exception {
        return trainTimeStationDao.getTrainTimeStationById(trainTimeStationId);
    }

    @Override
    public void updateTrainTimeStation(TrainTimeStation trainTimeStation) throws Exception {
        trainTimeStationDao.updateTrainTimeStation(trainTimeStation);
    }

    @Override
    public void deleteTrainTimeStation(Long trainTimeStationId) throws Exception {
        trainTimeStationDao.deleteTrainTimeStation(trainTimeStationId);
    }
}
