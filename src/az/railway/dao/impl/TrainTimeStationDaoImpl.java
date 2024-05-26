package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.TrainTimeStationDao;
import az.railway.model.Direction;
import az.railway.model.Station;
import az.railway.model.Train;
import az.railway.model.TrainTimeStation;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;
import az.railway.sql.UpdateConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TrainTimeStationDaoImpl implements TrainTimeStationDao {
    @Override
    public List<TrainTimeStation> getTrainTimeStationList() throws Exception {
        String sql = SelectConstant.GET_TRAIN_TIME_STATION_LIST;
        List<TrainTimeStation> listTrainTimeStation = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                TrainTimeStation trainTimeStation = new TrainTimeStation();
                trainTimeStation.setId(rs.getLong("TRAIN_TIME_STATION_ID"));
                trainTimeStation.setTime(rs.getString("TIME"));
                Train train = new Train();
                train.setTrainNumber(rs.getInt("TRAIN_NUMBER"));
                Direction direction = new Direction();
                direction.setDirectionName(rs.getString("DIRECTION_NAME"));
                train.setDirection(direction);
                Station station = new Station();
                station.setStationName(rs.getString("STATION_NAME"));
                trainTimeStation.setStation(station);
                trainTimeStation.setTrain(train);
                listTrainTimeStation.add(trainTimeStation);
            }
        }
        return listTrainTimeStation;
    }

    @Override
    public void addTrainTimeStation(TrainTimeStation trainTimeStation) throws Exception {
        String sql = InsertConstant.INSERT_TRAIN_TIME_STATION;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, trainTimeStation.getStation().getId());
            ps.setLong(2, trainTimeStation.getTrain().getId());
            ps.setString(3, trainTimeStation.getTime());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public TrainTimeStation getTrainTimeStationById(Long trainTimeStationId) throws Exception {
        String sql = SelectConstant.GET_TRAIN_TIME_STATION_LIST_BY_ID;
        TrainTimeStation trainTimeStation = new TrainTimeStation();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, trainTimeStationId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                trainTimeStation.setId(rs.getLong("TRAIN_TIME_STATION_ID"));
                trainTimeStation.setTime(rs.getString("TIME"));
                Train train = new Train();
                train.setTrainNumber(rs.getInt("TRAIN_NUMBER"));
                Direction direction = new Direction();
                direction.setDirectionName(rs.getString("DIRECTION_NAME"));
                train.setDirection(direction);
                Station station = new Station();
                station.setStationName(rs.getString("STATION_NAME"));
                trainTimeStation.setStation(station);
                trainTimeStation.setTrain(train);
            }
        }
        return trainTimeStation;
    }

    @Override
    public void updateTrainTimeStation(TrainTimeStation trainTimeStation) throws Exception {
        String sql = UpdateConstant.UPDATE_TRAIN_TIME_STATION;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, trainTimeStation.getStation().getId());
            ps.setLong(2, trainTimeStation.getTrain().getId());
            ps.setString(3, trainTimeStation.getTime());
            ps.setLong(4, trainTimeStation.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteTrainTimeStation(Long trainTimeStationId) throws Exception {
        String sql = UpdateConstant.DELETE_TRAIN_TIME_STATION;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, trainTimeStationId);
            ps.execute();
            c.commit();
        }
    }
}
