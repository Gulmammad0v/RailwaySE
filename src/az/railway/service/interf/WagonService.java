package az.railway.service.interf;

import az.railway.model.Wagon;

import java.util.List;

public interface WagonService {
    List<Wagon> getWagonList() throws Exception;

    void addWagon(Wagon wagon) throws Exception;

    Wagon getWagonById(Long wagonId) throws Exception;
}
