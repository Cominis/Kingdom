package org.daumantas.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Mission.findAll",
                query = "select m from Mission as m"
        )
})
@Table(name = "MISSION")
@Getter @Setter
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique=true)
    private String title;

    private String country;

    @ManyToMany(mappedBy = "missions")
    private List<King> kings = new ArrayList<>();

    public Mission(){
    }
}
