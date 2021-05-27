package jobits.assignment.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userIndex", nullable = false)
    private Long userIndex;

    @Column(length = 20, name = "userID", nullable = false)
    private String userID;

    @Column(length = 20, name = "userPassword", nullable = false)
    private String userPassword;
}
