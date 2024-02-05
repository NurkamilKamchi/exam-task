package java12;

import java12.Entities.BlogPost;
import java12.Entities.Comment;
import java12.Entities.Role;
import java12.Entities.User;
import java12.config.Util;
import java12.services.BlogPostServiceImpl;
import java12.services.UserService;
import java12.services.impl.BlogServiceImpl;
import java12.services.impl.CommentServiceImpl;
import java12.services.impl.UserServiceImpl;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        CommentServiceImpl commentService = new CommentServiceImpl();
        BlogPostServiceImpl blogPostService = new BlogServiceImpl();
        System.out.println(userService.getAllUsers());
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("""
                                ***User ***
                        2. String saveUser ();
                        3. List<User> getAllUsers ();
                        4. String updateUserById (Long userId);
                        5. String deleteUserById (Long userId);
                                                  
                                 ***Post ***
                        6. String createTable ();
                        7. List<BlogPost> getAllPosts ();
                        8. String updatePostById (Long postId, BlogPost newBlogPost);
                        9. String deletePostById (Long postId);
                        10. BlogPost getPostById (Long postId);
                        11. BlogPost searchPostByKeywoard (String keywoard);
                                                     
                                 ***Comment ***
                        12. String createComment ();
                        13. List<Comment> getAllComments ();
                        14. String updateCommentById (Long commentId, Comment newComment);
                        15. String deleteCommentById (Long commentId);
                        """);
                switch (scanner.nextInt()) {
                    case 2 -> {
                        System.out.println(userService.saveUser());
                    }
                    case 3 -> {
                        System.out.println(userService.getAllUsers());
                    }
                    case 4 -> {
                        System.out.println(userService.updateUserById(1L, new User()));
                    }
                    case 5 -> {
                        System.out.println(userService.deleteUserById(1L));
                    }
                    case 6 -> {
                        System.out.println(blogPostService.createTable());
                    }
                    case 7 -> {
                        System.out.println(blogPostService.getAllPosts());
                    }
                    case 8 -> {
                        System.out.println(blogPostService.updatePostById(1L, new BlogPost()));
                    }
                    case 9 -> {
                        System.out.println(blogPostService.deletePostById(1L));
                    }
                    case 10 -> {
                        System.out.println(blogPostService.getPostById(1L));
                    }
                    case 11 -> {
                        System.out.println(blogPostService.searchPostByKeywoard("woard"));
                    }
                    case 12 -> {
                        System.out.println(commentService.createComment());
                    }
                    case 13 -> {
                        System.out.println(commentService.getAllComments());
                    }
                    case 14 -> {
                        System.out.println(commentService.updateCommentById(1L, new Comment()));
                    }
                    case 15 -> {
                        System.out.println(commentService.deleteCommentById(1L));
                    }
                    case 16 -> {
                        System.out.println(commentService.sortPostByPublishedYear());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}




