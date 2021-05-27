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
    private Long postNumber;

    @Column(length = 45, name = "postTitle", nullable = false)
    private String postTitle;

    @Column(length = 200, name = "postText", nullable = false)
    private String postText;

    @Column(name = "postImage")
    private Blob postImage;

    @OneToOne
    @JoinColumn(name = "User_userID", nullable = false)
    private User userID;

    @Column(name = "delete_YN", nullable = false)
    private String delete_YN = "N";

    @Builder
    public Post(String postTitle, String postText, Blob postImage) {
        this.postTitle = postTitle;
        this.postText = postText;
        this.postImage = postImage;
    }
}
