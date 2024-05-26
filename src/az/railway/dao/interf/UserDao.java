package az.railway.dao.interf;

import az.railway.model.Customer;
import az.railway.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList() throws Exception;

    void addUser(User user) throws Exception;

    User getUserById(Long userId) throws Exception;

    void updateUser(User user) throws Exception;

    void deleteUser(Long userId) throws Exception;

    List<User> searchUserData(String keyword) throws Exception;
}
