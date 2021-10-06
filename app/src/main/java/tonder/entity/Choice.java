package tonder.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Choice {
    @Id
    @SequenceGenerator(name = "choice_id_seq_generator", sequenceName = "choice_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "choice_id_seq_generator")
    private Integer id;

    @Column(name = "profile_id")
    private Integer profileId;

    @Column(name = "choice")
    private Boolean choice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User    user;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;
}
