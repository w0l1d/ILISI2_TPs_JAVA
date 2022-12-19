package com.java.ilisi.tp3;

import com.java.ilisi.tp3.enums.Civilite;

import java.util.Objects;

public record Client(String nom, String prenom, String cin, Civilite civilite) implements Comparable<Client> {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(nom, client.nom)
                && Objects.equals(prenom, client.prenom)
                && Objects.equals(cin, client.cin)
                && civilite == client.civilite;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
                ", civilite=" + civilite +
                '}';
    }

    @Override
    public int compareTo(Client o) {
        return cin().compareTo(o.cin());
    }
}
