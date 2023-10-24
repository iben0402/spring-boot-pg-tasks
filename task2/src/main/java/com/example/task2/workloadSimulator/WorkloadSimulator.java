package com.example.task2.workloadSimulator;

import com.example.task2.astronaut.Astronaut;

import java.util.concurrent.TimeUnit;

public class WorkloadSimulator {
    public static void simulateWorkload(Astronaut astronaut) {
        System.out.println("Working on astronaut: " + astronaut.getName());
        try {
            // Simulate workload by sleeping for 3 seconds
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Finished working on astronaut: " + astronaut.getName());

    }
}


