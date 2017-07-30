package com.example.szilsan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by szilsan on 11/07/2017.
 */

@Component
public class SimulationManager implements CommandLineRunner{

    @Autowired
    private SimulationThreadScheduled simulationThreadScheduled = new SimulationThreadScheduled();

    @Autowired
    private SimulationThread simulationThread;

    public SimulationManager() {
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

    public void exitSimulation() {
        simulationThreadScheduled.setStatus(SimulationStatus.EXIT);
    }

    @Override
    public void run(String... strings) throws Exception {
        simulationThread.run();
    }

    // GETTERS SETTERS
    public SimulationThreadScheduled getSimulationThreadScheduled() {
        return simulationThreadScheduled;
    }

    public SimulationThread getSimulationThread() {
        return simulationThread;
    }

    public void setSimulationThread(SimulationThread simulationThread) {
        this.simulationThread = simulationThread;
    }

}
