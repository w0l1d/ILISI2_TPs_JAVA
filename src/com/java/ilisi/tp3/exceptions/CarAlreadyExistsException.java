package com.java.ilisi.tp3.exceptions;

import com.java.ilisi.tp3.model.Voiture;

public class CarAlreadyExistsException extends Throwable {
   public CarAlreadyExistsException(Voiture v) {
      super("Error : Voiture %s deja existe".formatted(v.matricule()));
   }
}
