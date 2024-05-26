package az.railway.dao.interf;

import az.railway.model.Place;

import java.util.LinkedList;
import java.util.List;

public interface PlaceDao {
    List<Place> getPlaceList() throws Exception;

    void addPlace(Place place) throws Exception;

    Place getPlaceById(Long placeId) throws Exception;
}
