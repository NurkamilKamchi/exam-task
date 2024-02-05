package java12.dao.impl;

import java12.Entities.BlogPost;
import java12.Entities.Comment;
import java12.Entities.Role;
import java12.Entities.User;
import java12.config.Util;
import java12.dao.BlogPostDao;
import java12.dao.CommentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CommentDaoImpl implements CommentDao {
    private final Connection connection = Util.getConnection();
    public String createComment() {
        String query = """
                create table comments(
                             id serial primary key,
                          comment_text varchar,
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
    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<>();
        String query = """
                select * from comments;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Comment comment = new Comment();
                comment.setId(resultSet.getLong("id"));
                comment.setComment_text((resultSet.getString("comment_text")));
                Date sqlDate = resultSet.getDate("publish_date");
                LocalDate publishDate = (sqlDate != null) ? ((java.sql.Date) sqlDate).toLocalDate() : null;
                comment.setPublish_date(publishDate);
                comments.add(comment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return comments;
    }

    @Override
    public String updateCommentById(Long ucommentId,Comment newComment) {
        String query = """
                update  comments set comment_text = ? ,publish_date = ? ;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setString(1,newComment.getComment_text());
            preparedStatement.setDate(1, java.sql.Date.valueOf(newComment.getPublish_date()));
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
    public String deleteCommentById(Long commentId) {
        String query = """
                delete from users where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setLong(1,commentId);
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
    public List<BlogPostDao> sortPostByPublishedYear() {
        List<BlogPostDao> blogPostDaos = new ArrayList<>();
        String q = """
                select * from blogPosts order by publish_year;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(q);){
            ResultSet resultSet = preparedStatement.executeQuery();
            blogPostDaos.add((BlogPostDao) resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public Map<BlogPost, List<Comment>> groupCommentsByPost() {
        return null;
    }

}
