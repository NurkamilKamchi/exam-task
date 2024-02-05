package java12.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "blogPosts")
public class BlogPost {
    @Id
     private Long id;
    @Column
    private String title;
    @Column
    private Content content;
    @Column
    private LocalDate publish_date;
    @OneToMany(mappedBy = "blogPost",cascade = CascadeType.REMOVE)
    private List<Comment> comments;

}
