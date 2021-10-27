package tonder.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@NamedEntityGraphs({
        @NamedEntityGraph(name = "User.roles", attributeNodes = {
                @NamedAttributeNode(value = "roles")
        })
})
@Entity
public class User {

    @Id
    @SequenceGenerator(name = "user_id_seq_generator", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq_generator")
    private Integer id;

    @Column(name = "username", unique = true)
    private String  username;

    @Column(name = "password")
    private String  password;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;
}

