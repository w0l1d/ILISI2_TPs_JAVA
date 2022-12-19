package com.java.ilisi.tp1.ex1;

import java.util.Arrays;

public class classeMorse {

    public static void print(String ...mots) {
        Arrays.stream(mots).map(s -> s+" Stop. ").forEach(System.out::print);
    }
    public static void main(String[] args) {
        print("Java","Morse","ceci","est","drole");
    }

}
