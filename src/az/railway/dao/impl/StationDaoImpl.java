package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.StationDao;
import az.railway.model.Station;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;
import az.railway.sql.UpdateConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StationDaoImpl implements StationDao {
    @Override
    public List<Station> getStationList() throws Exception {
        String sql = SelectConstant.GET_STATION_LIST;
        List<Station> listStation = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Station station = new Station();
                station.setId(rs.getLong("ID"));
                station.setStationName(rs.getString("STATION_NAME"));
                listStation.add(station);
            }
        }
        return listStation;
    }

    @Override
    public void addStation(Station station) throws Exception {
        String sql = InsertConstant.INSERT_STATION;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, station.getStationName());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Station getStationById(Long stationId) throws Exception {
        String sql = SelectConstant.GET_STATION_BY_ID;
        Station station = new Station();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, stationId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                station.setId(rs.getLong("ID"));
                station.setStationName(rs.getString("STATION_NAME"));
            }
        }
        return station;
    }

    @Override
    public void updateStation(Station station) throws Exception {
        String sql = UpdateConstant.UPDATE_STATION;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, station.getStationName());
            ps.setLong(2, station.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteStation(Long stationId) throws Exception {
        String sql = UpdateConstant.DELETE_STATION;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, stationId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<Station> searchStationData(String keyword) throws Exception {
        String sql = SelectConstant.SEARCH_STATION_DATA;
        List<Station> listStation = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Station station = new Station();
                station.setId(rs.getLong("ID"));
                station.setStationName(rs.getString("STATION_NAME"));
                listStation.add(station);
            }
        }
        return listStation;
    }
}
