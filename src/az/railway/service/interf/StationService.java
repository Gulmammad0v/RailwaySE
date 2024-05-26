package az.railway.service.interf;

import az.railway.model.Station;

import java.util.List;

public interface StationService {
    List<Station> getStationList() throws Exception;

    void addStation(Station station) throws Exception;
    Station getStationById(Long stationId) throws Exception;

    void updateStation(Station station) throws Exception;

    void deleteStation(Long stationId) throws Exception;

    List<Station> searchStationData(String keyword) throws Exception;
}
