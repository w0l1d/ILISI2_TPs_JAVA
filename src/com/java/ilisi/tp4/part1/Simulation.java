package com.java.ilisi.tp4.part1;

public class Simulation {


    public static void main(String[] args) throws InterruptedException {
        VerificateurJouet verifAmine = new VerificateurJouet("Ahmed");
        VerificateurJouet verifAhmed = new VerificateurJouet("Amine");
        verifAhmed.thread.start();
        verifAmine.thread.start();
        try {
            verifAhmed.thread.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            verifAmine.thread.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
