package com.example.szilsan;

import com.example.szilsan.model.SimulationModel;
import com.example.szilsan.model.SimulationModelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by szilsan on 11/07/2017.
 */

@Component
public class SimulationManager implements CommandLineRunner{

    @Autowired
    private SimulationModel model;

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
        model.getGlobes().clear();
        simulationThread.setStatus(SimulationStatus.RUNNING);
    }

    public void exitSimulation() {
        simulationThread.setStatus(SimulationStatus.EXIT);
    }

    @Override
    public void run(String... strings) throws Exception {
        model.getGlobes().addAll(SimulationModelFactory.createDefaultModel().getGlobes());
        simulationThread.run();
    }

    // GETTERS SETTERS
    public SimulationModel getModel() {
        return model;
    }
}
