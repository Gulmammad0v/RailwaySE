package az.railway.service.impl;

import az.railway.dao.interf.TrainEmployeeDao;
import az.railway.model.TrainEmployee;
import az.railway.service.interf.TrainEmployeeService;

import java.util.List;

public class TrainEmployeeServiceImpl implements TrainEmployeeService {
    TrainEmployeeDao trainEmployeeDao;

    public TrainEmployeeServiceImpl(TrainEmployeeDao trainEmployeeDao) {
        this.trainEmployeeDao = trainEmployeeDao;
    }

    @Override
    public List<TrainEmployee> getTrainEmployeeList() throws Exception {
        return trainEmployeeDao.getTrainEmployeeList();
    }

    @Override
    public void addTrainEmployee(TrainEmployee trainEmployee) throws Exception {
        trainEmployeeDao.addTrainEmployee(trainEmployee);
    }
}
