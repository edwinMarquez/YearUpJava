package org.example.models;


import jakarta.persistence.*;


@Entity
@Table(name = "pokemon_type")
public class PokemonType {

    @Id
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
