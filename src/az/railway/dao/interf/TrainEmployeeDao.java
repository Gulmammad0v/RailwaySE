package az.railway.dao.interf;

import az.railway.model.TrainEmployee;

import java.util.List;

public interface TrainEmployeeDao {
    List<TrainEmployee> getTrainEmployeeList() throws Exception;

    void addTrainEmployee(TrainEmployee trainEmployee) throws Exception;
}
