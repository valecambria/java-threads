package org.example.ejemploexecutor;

import org.example.ejemplosync.Panaderia;
import org.example.ejemplosync.runnable.Consumidor;
import org.example.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2); //con este cast de threadpoolexecutor accedo a metodos como el get, set, etc.
        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola" + executor.getQueue().size());

        Panaderia p = new Panaderia();
        Runnable panadero = new Panadero(p);
        Runnable consumidor = new Consumidor(p);

        Future<?> resultado = executor.submit(panadero);
        Future<?> resultado2 = executor.submit(consumidor);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola " + executor.getQueue().size());
        executor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main");


    }
}
