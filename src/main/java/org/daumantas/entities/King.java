package org.daumantas.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "King.findAll",
                query = "SELECT k FROM King AS k"
        )
})
@Table(name = "KING")
@Getter @Setter
public class King {

    public King() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", unique = true)
    private String name;

    @OneToMany(mappedBy = "king")
    private List<Knight> knights = new ArrayList<>();

    @ManyToMany
    @JoinColumn(name="ID")
    private List<Mission> missions = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        King king = (King) o;
        return Objects.equals(id, king.id) &&
                Objects.equals(name, king.name);
    }

    @Override
    public int hashCode() { return Objects.hash(name); }
}
