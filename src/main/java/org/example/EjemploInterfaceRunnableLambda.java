package org.example;

import org.example.runnable.ViajeTarea;

public class EjemploInterfaceRunnableLambda {
    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();
        Runnable viaje = () -> {
            for (int i = 0; i < 10; i++){
                System.out.println(i + " - " + Thread.currentThread().getName());
                try {
                    Thread.sleep((long)(Math.random() * 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Me voy de viaje a " + Thread.currentThread().getName());
            System.out.println(main.getState());
        };

        Thread v1 = new Thread(viaje, "Isla de pascua");
        Thread v2 = new Thread(viaje,"Bariloche");
        Thread v3 = new Thread(viaje,"Mendoza");

        v1.start();
        v2.start();
        v3.start();
        v1.join();
        v2.join();
        v3.join();
        System.out.println("Continuando con la ejecucion del metodo main");
    }
}
