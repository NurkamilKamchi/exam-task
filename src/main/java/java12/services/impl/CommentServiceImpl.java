package java12.services.impl;

import java12.Entities.Comment;
import java12.dao.BlogPostDao;
import java12.dao.CommentDao;
import java12.dao.impl.CommentDaoImpl;

import java.util.List;

public class CommentServiceImpl implements java12.services.CommentServiceImpl {
    private final CommentDao commentDao = new CommentDaoImpl();
    @Override
    public String createComment() {
        return commentDao.createComment();
    }

    @Override
    public List<Comment> getAllComments() {
        return commentDao.getAllComments();
    }

    @Override
    public String updateCommentById(Long commentId, Comment newComment) {
        return commentDao.updateCommentById(commentId,newComment);
    }

    @Override
    public String deleteCommentById(Long commentId) {
        return commentDao.deleteCommentById(commentId);
    }

    @Override
    public List<BlogPostDao> sortPostByPublishedYear() {
        return commentDao.sortPostByPublishedYear();
    }
}
