package az.railway.dao.interf;

import az.railway.model.Row;

import java.util.List;

public interface RowDao {
    List<Row> getRowList() throws Exception;

    void addRow(Row row) throws Exception;

    Row getRowById(Long rowId) throws Exception;
}
