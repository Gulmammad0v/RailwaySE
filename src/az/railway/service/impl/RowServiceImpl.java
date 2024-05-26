package az.railway.service.impl;

import az.railway.dao.interf.RowDao;
import az.railway.model.Row;
import az.railway.service.interf.RowService;

import java.util.List;

public class RowServiceImpl implements RowService {
    RowDao rowDao;

    public RowServiceImpl(RowDao rowDao) {
        this.rowDao = rowDao;
    }

    @Override
    public List<Row> getRowList() throws Exception {
        return rowDao.getRowList();
    }

    @Override
    public void addRow(Row row) throws Exception {
        rowDao.addRow(row);
    }

    @Override
    public Row getRowById(Long rowId) throws Exception {
       return rowDao.getRowById(rowId);
    }
}
