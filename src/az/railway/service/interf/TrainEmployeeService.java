package az.railway.service.interf;

import az.railway.model.TrainEmployee;

import java.util.List;

public interface TrainEmployeeService {
    List<TrainEmployee> getTrainEmployeeList() throws Exception;

    void addTrainEmployee(TrainEmployee trainEmployee) throws Exception;
}
