package org.example;


import jakarta.persistence.*;
import org.example.models.Pokemon;
import org.example.models.PokemonType;

import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello world!");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokedex");
        EntityManager entityManager = emf.createEntityManager();

        System.out.println("******************** POKEdex *******************");
        String line;
        do {
            System.out.println("=================== MENU =================");
            System.out.println("||\t 1) Create entry");
            System.out.println("||\t 2) Read entries");
            System.out.println("||\t 3) Update");
            System.out.println("||\t 4) Delete entry");
            System.out.println("||\t 5) quit");
            line = scanner.nextLine();
            switch (line) {
                case "1" -> insertNewPokemon(entityManager);
                case "2" -> queryAll(entityManager);
                case "3" -> update(entityManager);
                case "4" -> delete(entityManager);
            }
        } while (!line.trim().equals("quit") && !line.trim().equals("5"));
        emf.close();
    }


    private static void insertNewPokemon(EntityManager em) {
        System.out.println("======================== new Registry ==== ");
        Pokemon pokemon;
        System.out.print("Insert a Name: ");
        String pokemonName = scanner.nextLine().trim().toLowerCase();
        pokemon = em.find(Pokemon.class,pokemonName);
        if(pokemon != null){
            System.out.println("*******************! Already Existing");
            return;
        }
        System.out.print("Insert pokemon Type: ");
        String pType = scanner.nextLine().trim().toLowerCase();
        PokemonType pokemonType = em.find(PokemonType.class,pType);
        if(pokemonType == null){
            pokemonType = new PokemonType();
            pokemonType.setType(pType);
        }
        pokemon = new Pokemon();
        pokemon.setName(pokemonName);
        pokemon.setType(pokemonType);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(pokemonType);
        em.persist(pokemon);
        et.commit();
        System.out.println("*******************! Registered");
    }



    private static void queryAll(EntityManager em) {
        List<Pokemon> pokemon = (List<Pokemon>) em.createQuery("from Pokemon").getResultList();
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder,Locale.US);
        String format = "| %20s || %10s |"; //format string 20 chars, and 10 chars.

        stringBuilder.append("---------------------------------------").append("\n");
        formatter.format(format,"Name", "Type");
        stringBuilder.append("\n").append("---------------------------------------").append("\n");
        for (Pokemon pt : pokemon) {
            formatter.format(format,pt.getName(), pt.getType().getType());
            stringBuilder.append("\n");
        }
        stringBuilder.append("---------------------------------------").append("\n");
        System.out.println("******************* printing all: ");
        System.out.println(stringBuilder);
        System.out.println("**********************************");
    }

    private static void update(EntityManager em){
        System.out.println("Updating pokemon");
        System.out.print("What pokemon would you like to update?");
        String pName = scanner.nextLine();
        Pokemon pokemon = em.find(Pokemon.class,pName);
        if(pokemon == null){
            System.out.println("**************** Not found on database");
            return;
        }
         System.out.print("What type would you like to give it? ");
         String pNType = scanner.nextLine();
         PokemonType pokemonType = em.find(PokemonType.class,pNType);
         if(pokemonType == null){
             pokemonType = new PokemonType();
         }
         pokemonType.setType(pNType);
         pokemon.setType(pokemonType);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(pokemonType);
        em.persist(pokemon);
        et.commit();
        System.out.println("*******************! Updated");

    }

    private static void delete(EntityManager em){
        System.out.println("Deleting pokemon");
        System.out.print("What pokemon would you like to delete?");
        String pName = scanner.nextLine();
        Pokemon pokemon = em.find(Pokemon.class,pName);
        if(pokemon == null){
            System.out.println("****! Not found in the database");
            return;
        }
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(pokemon);
        System.out.println("****! DELETED");
        transaction.commit();
    }

}