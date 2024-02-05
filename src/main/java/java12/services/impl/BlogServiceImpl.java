package java12.services.impl;

import java12.Entities.BlogPost;
import java12.dao.BlogPostDao;
import java12.dao.impl.BlogPostDaoImpl;
import java12.services.BlogPostServiceImpl;

import java.util.List;

public class BlogServiceImpl implements BlogPostServiceImpl {
    private final BlogPostDao blogPostDao = new BlogPostDaoImpl();
    @Override
    public String createTable() {
        return blogPostDao.createTable();
    }

    @Override
    public List<BlogPost> getAllPosts() {
        return blogPostDao.getAllPosts();
    }

    @Override
    public String updatePostById(Long postId, BlogPost newBlogPost) {
        return blogPostDao.updatePostById(postId,newBlogPost);
    }

    @Override
    public String deletePostById(Long postId) {
        return blogPostDao.deletePostById(postId);
    }

    @Override
    public BlogPost getPostById(Long postId) {
        return blogPostDao.getPostById(postId);
    }

    @Override
    public BlogPost searchPostByKeywoard(String keywoard) {
        return blogPostDao.searchPostByKeywoard(keywoard);
    }
}
