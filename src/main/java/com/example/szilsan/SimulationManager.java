package com.example.szilsan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * Created by szilsan on 11/07/2017.
 */

@Component
public class SimulationManager implements CommandLineRunner{

    private SimulationStatus status;

    @Autowired
    private SimulationThread simulationThread = new SimulationThread();

    @Autowired
    private SimulationThread2 simulationThread2;

    public SimulationManager() {
        startSimulation();
    }

    public void startSimulation() {
        simulationThread.run();
    }

    public void continueSimulation() {
        simulationThread.setStatus(SimulationStatus.RUNNING);
    }

    public void stopSimulation() {
        simulationThread.setStatus(SimulationStatus.STOPPED);
    }

    public void restartSimulation() {
        simulationThread.setStatus(SimulationStatus.NOT_STARTED);
        simulationThread.setStatus(SimulationStatus.RUNNING);
    }

    @Override
    public void run(String... strings) throws Exception {
        simulationThread2.run();
    }


    // GETTERS SETTERS
    public SimulationThread getSimulationThread() {
        return simulationThread;
    }

    public void setSimulationThread(SimulationThread simulationThread) {
        this.simulationThread = simulationThread;
    }

    public SimulationThread2 getSimulationThread2() {
        return simulationThread2;
    }

    public void setSimulationThread2(SimulationThread2 simulationThread2) {
        this.simulationThread2 = simulationThread2;
    }

}
