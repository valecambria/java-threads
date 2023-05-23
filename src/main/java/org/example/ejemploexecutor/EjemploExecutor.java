package org.example.ejemploexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor(); //el executor service ademas de ejecutar una tarea, nos deja hacer un seguimiento de la misma

        Runnable tarea = () -> {
            System.out.println("Inicio de la tarea");
            try {
                System.out.println("Nombre del thread " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea");
        };
        executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main 1");
        executor.awaitTermination(2, TimeUnit.SECONDS); //Espera a que finalice la ejecucion de las tareas para seguir con la ejecucion del metodo main
        System.out.println("Continuando con la ejecucion del metodo main 2");
    }
}
