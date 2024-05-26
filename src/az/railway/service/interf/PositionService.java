package az.railway.service.interf;

import az.railway.model.Position;

import java.util.List;

public interface PositionService{
    List<Position> getPositionList() throws Exception;
    void addPosition(Position position) throws Exception;
    Position getPositionById(Long positionId) throws Exception;

    void updatePosition(Position position) throws Exception;

    void deletePosition(Long positionId) throws Exception;

    List<Position> searchPosition(String keyword) throws Exception;
}