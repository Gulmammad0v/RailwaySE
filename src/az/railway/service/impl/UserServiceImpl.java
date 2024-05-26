package az.railway.service.impl;

import az.railway.dao.interf.UserDao;
import az.railway.model.User;
import az.railway.service.interf.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUserList() throws Exception {
        return userDao.getUserList();
    }

    @Override
    public void addUser(User user) throws Exception {
        userDao.addUser(user);
    }

    @Override
    public User getUserById(Long userId) throws Exception {
        return userDao.getUserById(userId);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long userId) throws Exception {
        userDao.deleteUser(userId);
    }

    @Override
    public List<User> searchUserData(String keyword) throws Exception {
        return userDao.searchUserData(keyword);
    }
}
