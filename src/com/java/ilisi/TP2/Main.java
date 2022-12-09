package com.java.ilisi.TP2;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.text.DecimalFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static Scanner in = new Scanner(System.in);
    public static String tronque(double dbl, int dLimit) {
        String d = String.valueOf(dbl);
        int i = d.indexOf('.');
        if (i == -1)
            return d;
        return d.substring(0, i + 1 + dLimit);
    }
    public static void main(String[] args) {
//        System.out.print("> ");
//        String line = in.nextLine();
//        StringTokenizer st = new StringTokenizer(line, " ");
//        while (st.hasMoreTokens()) {
//            try {
//                System.out.println(tronque(Double.parseDouble(st.nextToken()), Integer.parseInt(st.nextToken())));
//            } catch (NumberFormatException e) {
//                System.err.println("Error : Format du premier double ou entier incorrect");
//            } catch (NoSuchElementException e) {
//                System.err.println("Error : entier n'est pas fourni");
//            }
//        }

        String s = in.nextLine();
        System.out.println("chaine : '"+s+"'");
        if (s.isEmpty())
                System.out.println("empty string");
        else
            System.out.println("not empty string");

        if (s.equals("\n"))
            System.out.println("== \\n");

    }
}
