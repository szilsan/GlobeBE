package com.example.szilsan.web;

import com.example.szilsan.SimulationManager;
import com.example.szilsan.model.Globe;
import com.example.szilsan.model.SimulationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by szilsan on 18/06/2017.
 */
@RestController
public class GlobeController {

    @Autowired
    private SimulationManager simulationManager;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Globe pilot project!";
    }

    @RequestMapping("/positions")
    public PositionsDTO positions() {
        final SimulationModel model = simulationManager.getModel();
        final PositionsDTO positionsDTO = new PositionsDTO();

        if (model != null && model.getGlobes().size() > 0) {
            for (Globe globe : model.getGlobes()) {
                //GlobeDTO globeDTO = new GlobeDTO(globe.getX(), globe.getY(), globe.getZ(), globe.getMass());
                //positionsDTO.getPositions().add(globeDTO);
            }
        }

        return positionsDTO;
    }

    @RequestMapping("/stop")
    public void stopSimulation(){
        simulationManager.stopSimulation();
    }

    @RequestMapping("/exit")
    public void exitSimulation(){
        simulationManager.exitSimulation();
    }

    @RequestMapping("/restart")
    public void restartSimulation(){
        simulationManager.restartSimulation();
    }

    @RequestMapping("/continue")
    public void continueSimulation(){
        simulationManager.continueSimulation();
    }
}