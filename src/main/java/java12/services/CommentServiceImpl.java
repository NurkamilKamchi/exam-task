package java12.services;

import java12.Entities.Comment;
import java12.dao.BlogPostDao;

import java.util.List;

public interface CommentServiceImpl {
    String createComment();

    List<Comment> getAllComments();
    String updateCommentById(Long commentId,Comment newComment);
    String deleteCommentById(Long commentId);
    List<BlogPostDao> sortPostByPublishedYear();
}
