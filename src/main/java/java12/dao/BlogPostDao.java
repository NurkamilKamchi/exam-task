package java12.dao;

import java12.Entities.BlogPost;
import java12.Entities.User;

import java.util.Date;
import java.util.List;

public interface BlogPostDao {
    String createTable();
    List<BlogPost> getAllPosts();
    String updatePostById(Long postId,BlogPost newBlogPost);
//    public String updatePostById(Long postId,BlogPost newBlogPost)

    String deletePostById(Long postId);
    BlogPost getPostById(Long postId);
    BlogPost searchPostByKeywoard(String keywoard);
}
