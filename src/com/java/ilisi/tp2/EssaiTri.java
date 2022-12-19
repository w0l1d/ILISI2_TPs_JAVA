package com.java.ilisi.tp2;

import java.util.Scanner;

public class EssaiTri {
    public static void main(String[] args) {
        TriSimple triSimple = new TriSimple(10, 3);
        Scanner in = new Scanner(System.in);
        String choix;
        do {
            int a;
            switch ((choix = in.nextLine()).charAt(0)) {
                case 'l':
                    System.out.println(triSimple);
                    break;
                case 'a':
                    a = Integer.parseInt(choix.substring(1).trim());
                    triSimple.inserer(a);
                    break;
                case 's':
                    a = Integer.parseInt(choix.substring(1).trim());
                    triSimple.supprimer(a);
                    break;
                case 'q':
                    System.out.println("Good Bye");
                    break;
                default:
                    System.out.println("Error : Choix Invalid");
            }
        } while (choix.charAt(0) != 'q');

    }
}
