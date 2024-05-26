package az.railway.dao.interf;


import az.railway.model.Direction;

import java.util.List;

public interface DirectionDao {
    List<Direction> getDirectionList() throws Exception;
}
