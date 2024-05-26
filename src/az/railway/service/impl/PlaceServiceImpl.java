package az.railway.service.impl;

import az.railway.dao.interf.PlaceDao;
import az.railway.model.Place;
import az.railway.service.interf.PlaceService;

import java.util.List;

public class PlaceServiceImpl implements PlaceService {
    PlaceDao placeDao;

    public PlaceServiceImpl(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    @Override
    public List<Place> getPlaceList() throws Exception {
        return placeDao.getPlaceList();
    }

    @Override
    public void addPlace(Place place) throws Exception {
        placeDao.addPlace(place);
    }

    @Override
    public Place getPlaceById(Long placeId) throws Exception {
        return placeDao.getPlaceById(placeId);
    }
}
