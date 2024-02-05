package java12.services;

import java12.Entities.BlogPost;

import java.util.List;

public interface BlogPostServiceImpl {
    String createTable();
    List<BlogPost> getAllPosts();
    String updatePostById(Long postId,BlogPost newBlogPost);
    String deletePostById(Long postId);
    BlogPost getPostById(Long postId);
    BlogPost searchPostByKeywoard(String keywoard);
}
