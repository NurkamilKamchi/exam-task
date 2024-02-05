package java12.dao;

import java12.Entities.BlogPost;
import java12.Entities.Comment;
import java12.Entities.User;

import java.util.List;
import java.util.Map;

public interface CommentDao {
    String createComment();

    List<Comment> getAllComments();
    String updateCommentById(Long commentId,Comment newComment);
    String deleteCommentById(Long commentId);
    List<BlogPostDao> sortPostByPublishedYear();
    Map<BlogPost,List<Comment>> groupCommentsByPost();
}
