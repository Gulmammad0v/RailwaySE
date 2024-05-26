package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.TrainDao;
import az.railway.model.Direction;
import az.railway.model.Train;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;
import az.railway.sql.UpdateConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TrainDaoImpl implements TrainDao {
    @Override
    public List<Train> getTrainList() throws Exception {
        String sql = SelectConstant.GET_TRAIN_LIST;
        List<Train> listTrain = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Train train = new Train();
                train.setId(rs.getLong("TRAIN_ID"));
                train.setTrainNumber(rs.getInt("TRAIN_NUMBER"));
                Direction direction = new Direction();
                direction.setDirectionName(rs.getString("DIRECTION_NAME"));
                train.setDirection(direction);
                listTrain.add(train);
            }
        }
        return listTrain;
    }

    @Override
    public void addTrain(Train train) throws Exception {
        String sql = InsertConstant.INSERT_TRAIN;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, train.getTrainNumber());
            ps.setLong(2, train.getDirection().getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Train getTrainById(Long trainId) throws Exception {
        String sql = SelectConstant.GET_TRAIN_BY_ID;
        Train train = new Train();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, trainId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                train.setId(rs.getLong("ID"));
                train.setTrainNumber(rs.getInt("TRAIN_NUMBER"));
                Direction direction = new Direction();
                direction.setDirectionName(rs.getString("DIRECTION_NAME"));
                train.setDirection(direction);
            }
        }
        return train;
    }

    @Override
    public void updateTrain(Train train) throws Exception {
        String sql = UpdateConstant.UPDATE_TRAIN;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, train.getTrainNumber());
            ps.setLong(2, train.getDirection().getId());
            ps.setLong(3, train.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteTrain(Long trainId) throws Exception {
        String sql = UpdateConstant.DELETE_TRAIN;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, trainId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<Train> searchTrainData(String keyword) throws Exception {
        String sql = SelectConstant.SEARCH_TRAIN_DATA;
        List<Train> listTrain = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(keyword));
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Train train = new Train();
                train.setId(rs.getLong("TICKET_ID"));
                train.setTrainNumber(rs.getInt("TRAIN_NUMBER"));
                Direction direction = new Direction();
                direction.setDirectionName(rs.getString("DIRECTION_NAME"));
                train.setDirection(direction);
                listTrain.add(train);
            }
        }
        return listTrain;
    }
}
