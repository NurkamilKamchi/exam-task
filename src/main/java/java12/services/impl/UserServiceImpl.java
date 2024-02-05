package java12.services.impl;

import java12.Entities.Role;
import java12.Entities.User;
import java12.dao.UserDao;
import java12.dao.impl.UserDaoImpl;
import java12.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public String saveUser() {
        return userDao.saveUser();
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public String updateUserById(Long userId,User newUser) {
        return userDao.updateUserById(userId, newUser) ;
    }

    @Override
    public String deleteUserById(Long userId) {
        return userDao.deleteUserById(userId);
    }
}
