package com.java.ilisi.tp1.ex2;

public class Somme {
    public static void main(String[] args) {
        int sum = 0;

        for (String arg : args) {
            try {
                sum += Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                System.err.println("Error: argument is not a valide number : " + e.getMessage());
            }
        }
        System.out.println("Resultat de la somme : " + sum);
    }

}
