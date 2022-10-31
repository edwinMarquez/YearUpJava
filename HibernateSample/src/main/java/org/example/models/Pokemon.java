package org.example.models;


import jakarta.persistence.*;

@Entity
@Table(name = "pokemon")
public class Pokemon {


    @Id
    String name;

    @ManyToOne
    @JoinColumn(name = "type")
    PokemonType type;

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
