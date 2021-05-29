package jobits.assignment.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, name = "title", nullable = false)
    private String title;

    @Column(length = 200, name = "content", nullable = false)
    private String content;

    @Column(name = "image")
    private Blob image = null;

    @Column(name = "delete_YN", nullable = false)
    private String delete_YN = "N";

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Post(String title, String content, Blob image) {
        this.title = title;
        this.content = content;
        this.image = image;
    }
}
