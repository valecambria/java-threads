package org.example;

import org.example.runnable.ImprimirFrases;

public class EjemploSincronizaciónThread {
    public static void main(String[] args) {

        new Thread(new ImprimirFrases("Hola, ", "que tal?" )).start();
        new Thread(new ImprimirFrases("Quien eres ", "tu?")).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread h3 = new Thread(new ImprimirFrases("Muchas ", "gracias amigo"));
        h3.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(h3.getState());
    }

    public synchronized static void imprimirFrase(String frase1, String frase2){ //cada hilo va a ser utilizado en orden con la palabra synchronized
        System.out.println(frase1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(frase2);
    }
}

