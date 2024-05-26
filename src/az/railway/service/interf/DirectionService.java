package az.railway.service.interf;

import az.railway.model.Direction;

import java.util.List;

public interface DirectionService {
    List<Direction> getDirectionList() throws Exception;
}
