package az.railway.service.impl;

import az.railway.dao.interf.TrainDao;
import az.railway.model.Train;
import az.railway.service.interf.TrainService;

import java.util.List;

public class TrainServiceImpl implements TrainService {
    private TrainDao trainDao;

    public TrainServiceImpl(TrainDao trainDao) {
        this.trainDao = trainDao;
    }

    @Override
    public List<Train> getTrainList() throws Exception {
        return trainDao.getTrainList();
    }

    @Override
    public void addTrain(Train train) throws Exception {
        trainDao.addTrain(train);
    }

    @Override
    public Train getTrainById(Long trainId) throws Exception {
        return trainDao.getTrainById(trainId);
    }

    @Override
    public void updateTrain(Train train) throws Exception {
        trainDao.updateTrain(train);
    }

    @Override
    public void deleteTrain(Long trainId) throws Exception {
        trainDao.deleteTrain(trainId);
    }

    @Override
    public List<Train> searchTrainData(String keyword) throws Exception {
        return trainDao.searchTrainData(keyword);
    }
}
