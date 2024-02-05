package java12.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Table(name = "comments")
@Getter
@Setter
public class Comment {
    @Id
    private Long id;
    @Column
    private String comment_text;
    @Column
    private LocalDate publish_date;
}
