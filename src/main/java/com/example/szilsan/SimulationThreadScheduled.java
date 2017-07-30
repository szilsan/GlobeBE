package com.example.szilsan;

import com.example.szilsan.model.SimulationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by szilsan on 11/07/2017.
 */
@Service
@Scope("singleton")
public class SimulationThreadScheduled {

    @Autowired
    private SimulationModel model = new SimulationModel();

    private long stepCount = 0;
    private SimulationStatus status = SimulationStatus.NOT_STARTED;
    private Logger logger = LoggerFactory.getLogger(SimulationThreadScheduled.class);

    @Scheduled(initialDelay = 3000, fixedDelay = 100)
    public void run() {
        if (status.equals(SimulationStatus.RUNNING)) {
            stepCount += 1;
            logger.debug("Count: {}", stepCount);
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
