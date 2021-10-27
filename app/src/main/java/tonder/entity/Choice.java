package tonder.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Choice {
    @Id
    @SequenceGenerator(name = "choice_seq_generator", sequenceName = "choice_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "choice_seq_generator")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "requester_id")
    private Profile requester;

    @OneToOne
    @JoinColumn(name = "adresser_id")
    private Profile adresser;
}
