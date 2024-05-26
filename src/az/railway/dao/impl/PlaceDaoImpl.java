package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.PlaceDao;
import az.railway.model.Class;
import az.railway.model.Place;
import az.railway.model.Row;
import az.railway.model.Wagon;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlaceDaoImpl implements PlaceDao {

    @Override
    public List<Place> getPlaceList() throws Exception {
        String sql = SelectConstant.GET_PLACE_LIST;
        List<Place> listPlace = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Place place = new Place();
                place.setId(rs.getLong("PLACE_ID"));
                place.setPlaceName(rs.getString("PLACE_NAME"));
                Row row = new Row();
                row.setRowName(rs.getInt("ROW_NAME"));
                Wagon wagon = new Wagon();
                wagon.setWagonName(rs.getString("WAGON_NAME"));
                Class aClass = new Class();
                aClass.setClassName(rs.getString("CLASS_NAME"));
                place.setRow(row);
                place.setWagon(wagon);
                place.setaClass(aClass);
                listPlace.add(place);
            }
        }
        return listPlace;
    }

    @Override
    public void addPlace(Place place) throws Exception {
        String sql = InsertConstant.INSERT_PLACE;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, place.getPlaceName());
            ps.setLong(2, place.getRow().getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Place getPlaceById(Long placeId) throws Exception {
        String sql = SelectConstant.GET_PLACE_BY_ID;
        Place place = new Place();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, placeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                place.setId(rs.getLong("PLACE_ID"));
                place.setPlaceName(rs.getString("PLACE_NAME"));
                Row row = new Row();
                row.setRowName(rs.getInt("ROW_NAME"));
                Wagon wagon = new Wagon();
                wagon.setWagonName(rs.getString("WAGON_NAME"));
                Class aClass = new Class();
                aClass.setClassName(rs.getString("CLASS_NAME"));
                place.setRow(row);
                place.setWagon(wagon);
                place.setaClass(aClass);
            }
        }
        return place;
    }
}
