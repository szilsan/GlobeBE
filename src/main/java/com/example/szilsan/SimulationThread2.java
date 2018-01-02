package com.example.szilsan;

import com.example.szilsan.model.SimulationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by szilsan on 11/07/2017.
 */
@Service
public class SimulationThread2 {

    @Autowired
    private SimulationModel model = new SimulationModel();

    private long stepCount = 0;
    private SimulationStatus status = SimulationStatus.NOT_STARTED;

    @Async
    public void run() {

        while (1 == 1) {
            try {
                stepCount += 1;
                System.out.println("Count2: " + stepCount);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    // GETTERS SETTERS
    public SimulationModel getModel() {
        return model;
    }

    public void setModel(SimulationModel model) {
        this.model = model;
    }

    public SimulationStatus getStatus() {
        return status;
    }

    public void setStatus(SimulationStatus status) {
        this.status = status;
        if (status.equals(SimulationStatus.NOT_STARTED)) {
            stepCount = 0;
            model = new SimulationModel();
        }
    }
}
