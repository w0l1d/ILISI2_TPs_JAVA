package com.java.ilisi.tp3.critere;

import com.java.ilisi.tp3.Voiture;

public interface Critere {
    /**
     * verifie si la voiture satisfait le critere
     *
     * @param v voiture a verfiee
     * @return si le critere est verifie
     */
    boolean estSatisfaitPar(Voiture v);
}
