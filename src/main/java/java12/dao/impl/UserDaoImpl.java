package java12.dao.impl;

import java12.Entities.Role;
import java12.Entities.User;
import java12.config.Util;
import java12.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private  final Connection connection =Util.getConnection();
    @Override
    public String saveUser() {
       String query = """
               create table users(
                            id serial primary key,
                         user_name varchar,
                       password int,
                                                role varchar
                                                );
               """;
        try ( PreparedStatement preparedStatement = connection.prepareStatement(query);){
            int i = preparedStatement.executeUpdate();
            if (i>=0){
                return ("Created!!!");
            }else {
                System.out.println("Not created!!!");
            }
        }catch (SQLException e){
            return (e.getMessage());
        }
        return null;
    }

    @Override
    public String saveUserToTable(User newUser) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = """
                select * from users;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUser_name(resultSet.getString("name"));
                user.setPassword(resultSet.getInt("password"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
                users.add(user);
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public String updateUserById(Long userId,User newUser) {
        String query = """
                update  users set user_name = ? ,password = ? , role = ?;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setString(1, newUser.getUser_name());
            preparedStatement.setInt(1,newUser.getPassword());
            preparedStatement.setString(1, String.valueOf(newUser.getRole()));
            int i = preparedStatement.executeUpdate();
            if (i>=0){
                return ("Success updated!!!");
            }else {
                System.out.println("Not success!!!");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteUserById(Long userId) {
        String query = """
                delete from users where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setLong(1,userId);
            int i = preparedStatement.executeUpdate();
            if (i>=0){
                return ("Success!!");
            }else {
                System.out.println("NOT");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
    }
        return null;
    }

    @Override
    public String changeRoleByUsernameandPassword(Role role, String username, String password) {
        String qu = """
                update users set role = ? where user_name = ? , password = ?;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(qu);){
            preparedStatement.setString(1,role);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,password);
            int i = preparedStatement.executeUpdate();
            if (i>=0){
                return "Succes!!";
            }else {
                System.out.println("Not");
            }
        }catch (SQLException e){
            return (e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getUserRole(Long userId) {
        String q = """
                select u.role from users u where u.id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(q);){
            preparedStatement.setLong(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery(q);
            return resultSet;
        }catch (SQLException e){
            System.out.println(e.getMessage()); ;
        }
        return null;
    }
}
