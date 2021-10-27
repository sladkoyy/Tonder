package tonder.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profile {
    @Id
    @SequenceGenerator(name = "profile_id_seq_generator", sequenceName = "profile_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_id_seq_generator")
    private Integer id;

    @OneToOne(mappedBy = "profile")
    private User    user;

    @OneToMany(mappedBy = "requester")
    private List<Choice> choices;

    @Column(name = "first_name")
    private String  firstName;

    @Column(name = "last_name")
    private String  lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private Character gender;

    @Column(name = "info")
    private String  info;
}
