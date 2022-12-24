package com.java.ilisi.tp1.ex3;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class Bibliotheque implements Serializable {
    private final int maxBooks;
    private final List<Livre> livres;

    public Bibliotheque(int maxBooks) {
        this.maxBooks = maxBooks;
        this.livres = new Vector<>(maxBooks);
    }

    public int capacite() {
        return maxBooks;
    }

    public void ajouterLivre(Livre livre) throws BiblioStureeException {
        if (livres.size() == maxBooks)
            throw new BiblioStureeException(capacite());
        livres.add(livre);
    }

    public int size() {
        return livres.size();
    }

    public Vector<Livre> getAllParAuteur(String auteur) {
        return livres.stream().filter(livre -> livre.containsAuthor(auteur)).collect(Collectors.toCollection(Vector::new));
    }

    public Livre getAnyParAuteur(String auteur) throws LivreNonTrouveException {
        return livres.stream().filter(livre -> livre.containsAuthor(auteur))
                .findFirst().orElseThrow(LivreNonTrouveException::new);
    }

    public Livre getParISBN(String isbn) throws LivreNonTrouveException {
        return livres.stream().filter(livre -> livre.getIsbn().equalsIgnoreCase(isbn))
                .findFirst().orElseThrow(LivreNonTrouveException::new);
    }

    public Livre getParTitre(String titre) throws LivreNonTrouveException {
        return livres.stream().filter(livre -> livre.getTitre().equalsIgnoreCase(titre))
                .findFirst().orElseThrow(LivreNonTrouveException::new);
    }

    public void suppParTitre(String titre) throws LivreNonTrouveException {
        supprimerLivre(getParTitre(titre));
    }
    public void suppParISBN(String isbn) throws LivreNonTrouveException {
        supprimerLivre(getParISBN(isbn));
    }
    public void suppAnyParAuteur(String auteur) throws LivreNonTrouveException {
        supprimerLivre(getAnyParAuteur(auteur));
    }

    public void supprimerLivre(Livre l) {
        livres.remove(l);
    }




    @Override
    public String toString() {
        return "Bibliotheque : \n" + livres.stream().map(Livre::toString).collect(Collectors.joining("\n")) + "\n";
    }

}
