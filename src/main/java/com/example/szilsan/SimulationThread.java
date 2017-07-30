package com.example.szilsan;

import com.example.szilsan.model.SimulationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by szilsan on 11/07/2017.
 */
@Service
public class SimulationThread {

    @Autowired
    private SimulationModel model = new SimulationModel();

    private long stepCount = 0;
    private SimulationStatus status = SimulationStatus.NOT_STARTED;
    private Logger logger = LoggerFactory.getLogger(SimulationThread.class);

    @Async
    public void run() {

        while (!status.equals(SimulationStatus.EXIT)) {
            try {
                stepCount += 1;
                logger.debug("Count2: {}", stepCount);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                logger.error("", e);
                Thread.currentThread().interrupt();
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
