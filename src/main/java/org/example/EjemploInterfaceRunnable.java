package org.example;

import org.example.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {

        new Thread(new ViajeTarea("Isla de pascua")).start();
        new Thread(new ViajeTarea("Bariloche")).start();
        new Thread(new ViajeTarea("Mendoza")).start();


    }
}
