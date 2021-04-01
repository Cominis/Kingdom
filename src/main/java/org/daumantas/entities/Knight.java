package org.daumantas.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Knight.findAll",
                query = "select k from Knight as k"
        )
})
@Table(name = "KNIGHT")
@Getter @Setter
public class Knight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 20)
    @Column(name = "NAME", unique=true)
    private String name;

    public Knight(){
    }

    @ManyToOne
    @JoinColumn(name="KING_ID")
    private King king;

    @Column(name = "PROFESSION")
    private String profession;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return Objects.equals(id, knight.id) &&
                Objects.equals(name, knight.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
