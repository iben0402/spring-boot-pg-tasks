package org.example.workloadSimulator;

import java.util.concurrent.TimeUnit;
import org.example.character.Character;

public class WorkloadSimulator {
    public static void simulateWorkload(Character character) {
        System.out.println("Working on character: " + character.getName());
        try {
            // Simulate workload by sleeping for 1 second
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


