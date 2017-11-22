package com.example.szilsan.model;

public class SimulationModelFactory {

    private static final double SUN_MASS = 1.989E30; //kg
    private static final double EARTH_MASS = 5.972E24; //kg

    public static SimulationModel createDefaultModel() {
        final SimulationModel simulationModel = new SimulationModel();
        Globe globe;

        // SUN
        globe = new Globe(10e10,0,0, SUN_MASS);
        globe.setCurrentSpeed(new Coordinate(0, 0, 0));
        simulationModel.getGlobes().add(globe);

        //EARTH
        globe = new Globe(0,0,0, EARTH_MASS);
        globe.setCurrentSpeed(new Coordinate(0, 0, 0));
        simulationModel.getGlobes().add(globe);

        return simulationModel;
    }
}
