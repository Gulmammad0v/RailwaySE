package az.railway.service.interf;

import az.railway.model.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getPlaceList() throws Exception;

    void addPlace(Place place) throws Exception;

    Place getPlaceById(Long placeId) throws Exception;
}
