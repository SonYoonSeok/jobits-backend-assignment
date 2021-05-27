package jobits.assignment.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20, name = "adminID", nullable = false)
    private String adminID;

    @Column(length =20, name = "adminPassword", nullable = false)
    private String adminPassword;
}
