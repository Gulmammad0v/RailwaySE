package az.railway.service.impl;

import az.railway.dao.interf.ClassDao;
import az.railway.model.Class;
import az.railway.service.interf.ClassService;

import java.util.List;

public class ClassServiceImpl implements ClassService {
    private ClassDao classDao;

    public ClassServiceImpl(ClassDao classDao) {
        this.classDao = classDao;
    }

    @Override
    public List<Class> getClassList() throws Exception {
        return classDao.getClassList();
    }

    @Override
    public void addClass(Class clas) throws Exception {
        classDao.addClass(clas);
    }

    @Override
    public Class getClassById(Long classId) throws Exception {
        return classDao.getClassById(classId);
    }

    @Override
    public void updateClass(Class clas) throws Exception {
        classDao.updateClass(clas);
    }

    @Override
    public void deleteClass(Long classId) throws Exception {
        classDao.deleteClass(classId);
    }

    @Override
    public List<Class> searchClassData(String keyword) throws Exception {
        return classDao.searchClassData(keyword);
    }
}
