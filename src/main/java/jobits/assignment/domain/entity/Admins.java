package jobits.assignment.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Admins")
public class Admins {

    @Id
    @Column(length = 20, name = "adminID", nullable = false)
    private String adminID;

    @Column(length = 20, name = "adminPassword", nullable = false)
    private String adminPassword;

    @Builder
    public Admins(String adminID, String adminPassword) {
        this.adminID = adminID;
        this.adminPassword = adminPassword;
    }
}
