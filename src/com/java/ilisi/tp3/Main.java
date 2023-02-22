package com.java.ilisi.tp3;

import com.java.ilisi.tp3.critere.CriterePrix;
import com.java.ilisi.tp3.enums.Civilite;
import com.java.ilisi.tp3.model.Client;
import com.java.ilisi.tp3.model.Voiture;

import java.util.HashMap;
import java.util.List;

public class Main {

   public static void main(String[] args) {

      List<Voiture> voitures = List.of(
              new Voiture("152-أ-1233", "Renault", "Clio", 2009, 100),
              new Voiture("152-ب-1566", "Volvo", "zeta", 2016, 99),
              new Voiture("81234-و-12", "peugeot", "partner", 2003, 90),
              new Voiture("123-د-154", "skoda", "alpha", 2009, 50),
              new Voiture("785-أ-89", "rover", "gama", 2016, 20),
              new Voiture("127-أ-999", "Mazi", "lexa", 2020, 700),
              new Voiture("654-ب-469", "tesla", "S serie", 2022, 300),
              new Voiture("963-د-895", "Ford", "transite", 2006, 40),
              new Voiture("753-ط-4885", "Ferari", "La Ferari", 2016, 600),
              new Voiture("75849-ف-9835", "Renault", "R4", 2000, 10)
      );

      new AgenceController();

//        Iterator<Voiture> iterator = voitures.iterator();
//        Collections.sort(voitures, Comparator.comparing(Voiture::marque));

      /*
       * Q 5 . En supposant que la référence agence est de type Agence
       *        et a été initialisée, donnez la ou les lignes de code
       *        permettant d'afficher toutes les voitures de cette agence
       *        dont le prix est inférieur à 100.
       */
      CriterePrix criterePrix = new CriterePrix(100);
      AgenceDAO agenceHash = new AgenceDAO(HashMap::new);
      agenceHash.addVoitures(voitures);
//      new AgenceGUI(agenceHash).setVisible(true);



        /*
            Q 7. Donnez la ou les lignes de code permettant de créer
                un critère intersection d'un critère pour la marque "Renaut",
                d’une année de production 2009
                et d'un critère pour un prix inférieur à 100.
         */


      // les clients de l'agence
      Client c1 = new Client("cli1", "man1", "X1234", Civilite.M),
              c2 = new Client("cli2", "man2", "Z1234", Civilite.M),
              c3 = new Client("cli3", "woman1", "W1234", Civilite.Mlle),
              c4 = new Client("cli4", "woman2", "R1234", Civilite.Mme);


      /*
       * Tester les locations avec HashMap
       */


      agenceHash.loueVoiture(c1, voitures.get(0));
      agenceHash.loueVoiture(c2, voitures.get(4));

      agenceHash.loueVoiture(c3, voitures.get(5));
      agenceHash.loueVoiture(c4, voitures.get(1));


   }


}
