package java12.dao.impl;

import java12.Entities.BlogPost;
import java12.Entities.Content;
import java12.config.Util;
import java12.dao.BlogPostDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogPostDaoImpl implements BlogPostDao {
    private final Connection connection = Util.getConnection();
    public String createTable() {
        String query = """
                create table blogPosts(
                             id serial primary key,
                          title varchar,
                          content varchar,
                                                 publish_date date
                                                 );
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);){
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
public List<BlogPost> getAllPosts() {
    List<BlogPost> blogPosts = new ArrayList<>();
    String query = "SELECT * FROM blogPosts";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            BlogPost blogPost = new BlogPost();
            blogPost.setId(resultSet.getLong("post_id"));
            blogPost.setTitle(resultSet.getString("title"));
            blogPost.setContent(Content.valueOf(resultSet.getString("content")));

            Date sqlDate = resultSet.getDate("publish_date");
            LocalDate publishDate = ((java.sql.Date) sqlDate).toLocalDate();

            blogPost.setPublish_date(publishDate);
            blogPosts.add(blogPost);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return blogPosts;
}


    @Override
public String updatePostById(Long postId,BlogPost newBlogPost) {
    String query = "UPDATE blogPosts SET title = ?, content = ?, publish_date = ? WHERE post_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setLong(1, postId);
        preparedStatement.setString(2, String.valueOf(newBlogPost.getContent()));
        preparedStatement.setDate(3, java.sql.Date.valueOf(newBlogPost.getPublish_date()));
        preparedStatement.setLong(4, postId);

        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            return "Success updated!!!";
        } else {
            System.out.println("Not success!!!");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return null;
}

    @Override
    public String deletePostById(Long postId) {
        String query = """
                delete from blogPosts where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setLong(1,postId);
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
    public BlogPost getPostById(Long postId) {
        String q = """
                select from blogPosts where id = ?;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(q);){
            preparedStatement.setLong(1,postId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return (BlogPost) resultSet;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public BlogPost searchPostByKeywoard(String keywoard) {
        String  q = """
                select from blogPosts where title like '%keywoard%';
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(q);) {
            preparedStatement.setString(1,keywoard);
            ResultSet resultSet = preparedStatement.executeQuery();
            return (BlogPost) resultSet;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
