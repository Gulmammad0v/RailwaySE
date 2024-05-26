package az.railway.service.interf;

import az.railway.model.Class;

import java.util.List;

public interface ClassService {
    List<Class> getClassList() throws Exception;
    void addClass(Class clas) throws Exception;
    Class getClassById(Long classId) throws Exception;

    void updateClass(Class clas) throws Exception;

    void deleteClass(Long classId) throws Exception;

    List<Class> searchClassData(String keyword) throws Exception;
}
