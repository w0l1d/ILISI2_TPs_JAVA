package com.java.ilisi.TP1.ex2;

public class Somme {

    public static void main(String[] args) {
        int sum = 0;



        try {
            for (String arg: args)
                sum += Integer.parseInt(arg);

            System.out.println("Resultat de la somme : " + sum);
        } catch (NumberFormatException e) {
            System.err.println("Error: argument is not a valide number");
            e.printStackTrace();
        }

    }

}
