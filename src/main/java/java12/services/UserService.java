package java12.services;

import java12.Entities.User;

import java.util.List;

public interface UserService {
    String saveUser();
    List<User> getAllUsers();
    String updateUserById(Long userId,User newUser);
    String deleteUserById(Long userId);
}
