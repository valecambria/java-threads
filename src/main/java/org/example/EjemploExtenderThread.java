package org.example;

import org.example.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) {

        Thread hilo = new NombreThread("John Doe");
        hilo.start();
        Thread hilo2 = new NombreThread("Maria");
        hilo2.start();
    }
}