package com.java.ilisi.tp3;

import com.java.ilisi.tp3.enums.Civilite;

import java.util.Objects;

public record Client(String nom, String prenom, String cin, Civilite civilite) implements Comparable<Client> {

    @Override
    public int hashCode() {
        return Objects.hash(cin);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(cin, client.cin);
    }

    @Override
    public String toString() {
        return cin + ", " + prenom + ", " + nom + ", " + civilite;
    }

    public String[] toArray() {
        return new String[]{cin, prenom, nom, civilite.toString()};
    }

    @Override
    public int compareTo(Client o) {
        return cin().compareTo(o.cin());
    }
}
