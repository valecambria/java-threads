package org.example;

import org.example.runnable.ViajeTarea;

public class EjemploInterfaceRunnableLambda {
    public static void main(String[] args) {

        Runnable viaje = () -> {
            for (int i = 0; i < 10; i++){
                try {
                    Thread.sleep((long)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Me voy de viaje a " + Thread.currentThread().getName());
            }
        };

        new Thread(new ViajeTarea("Isla de pascua")).start();
        new Thread(new ViajeTarea("Bariloche")).start();
        new Thread(new ViajeTarea("Mendoza")).start();


    }
}
