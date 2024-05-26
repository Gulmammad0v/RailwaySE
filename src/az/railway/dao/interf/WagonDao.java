package az.railway.dao.interf;

import az.railway.model.Wagon;

import java.util.List;

public interface WagonDao {
    List<Wagon> getWagonList() throws Exception;

    void addWagon(Wagon wagon) throws Exception;

    Wagon getWagonById(Long wagonId) throws Exception;
}
