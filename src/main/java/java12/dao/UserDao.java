package java12.dao;

import java12.Entities.Role;
import java12.Entities.User;

import java.sql.ResultSet;
import java.util.List;

public interface UserDao {
    String saveUser();
    String saveUserToTable(User newUser);
    List<User> getAllUsers();
    String updateUserById(Long userId,User newUser);
    String deleteUserById(Long userId);
    String changeRoleByUsernameandPassword(String username,String password);

    String changeRoleByUsernameandPassword(Role role, String username, String password);

    ResultSet getUserRole(Long userId);
}
