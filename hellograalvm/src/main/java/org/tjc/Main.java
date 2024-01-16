package org.tjc;

/**
 * Console Applicationlar icin GraalVM
 * 1) Class'ımızın bulunduğu dizine gidip .class uzantılı dosya elde etmemiz lazım. (javac Main.java)
 * 2) Projenin kök dizinine çıkmamız lazım. Yani 'java' dizinine gitmemiz lazım.
 * 3) native-image org.tjc.Main kodu ile native-image almamız lazım
 * 4) projenin kök dizininde ./org.tjc.main diyerek projeyi çalıştırmamız lazım.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}