package az.railway.service.interf;

import az.railway.model.Train;

import java.util.List;

public interface TrainService {
    List<Train> getTrainList() throws Exception;

    void addTrain(Train train) throws Exception;

    Train getTrainById(Long trainId) throws Exception;

    void updateTrain(Train train) throws Exception;

    void deleteTrain(Long trainId) throws Exception;

    List<Train> searchTrainData(String keyword) throws Exception;
}
