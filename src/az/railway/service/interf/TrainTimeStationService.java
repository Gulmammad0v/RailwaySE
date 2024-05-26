package az.railway.service.interf;

import az.railway.model.TrainTimeStation;

import java.util.List;

public interface TrainTimeStationService {
    List<TrainTimeStation> getTrainTimeStationList() throws Exception;

    void addTrainTimeStation(TrainTimeStation trainTimeStation) throws Exception;

    TrainTimeStation getTrainTimeStationById(Long trainTimeStationId) throws Exception;

    void updateTrainTimeStation(TrainTimeStation trainTimeStation) throws Exception;

    void deleteTrainTimeStation(Long trainTimeStationId) throws Exception;
}
