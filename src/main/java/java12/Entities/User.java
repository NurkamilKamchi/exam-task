package java12.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    @Id
    private Long id;
    @Column
    private String user_name;
    @Column
    private int password;
    @Enumerated(EnumType.STRING)
    @ToString.Exclude
    private Role role;

    public User(String user_name, int password, Role role) {
        this.user_name = user_name;
        this.password = password;
        this.role = role;
    }
}
