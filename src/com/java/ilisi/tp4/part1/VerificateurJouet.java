package com.java.ilisi.tp4.part1;

public class VerificateurJouet implements Runnable {
    public final Thread thread;
    private final String name;

    public VerificateurJouet(String name) {
        this.name = name;
        thread = new Thread(this);
    }

    public void verifieJouet(int jouet) throws InterruptedException {
        System.out.println("Le verificateur \"" + name + "\" verifie le jouet " + jouet);
        Thread.sleep((int) (Math.random() * 1000));
    }

    @Override
    public void run() {
    }
}
