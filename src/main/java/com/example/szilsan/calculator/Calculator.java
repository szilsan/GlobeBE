package com.example.szilsan.calculator;

import com.example.szilsan.SimulationThread;
import com.example.szilsan.model.Coordinate;
import com.example.szilsan.model.Force;
import com.example.szilsan.model.Globe;
import com.example.szilsan.model.SimulationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator implements ICalculator {

    private static double G = 6.673E-11; // Nm^2/kg^2

    @Autowired
    private SimulationModel model;

    private Logger logger = LoggerFactory.getLogger(Calculator.class);

    public void doCalc() {

        for (Globe globe1: model.getGlobes()) {
            for (Globe globe2: model.getGlobes()) {
                if (!globe1.equals(globe2)) {
                    final Force force = Calculator.calculateForce(globe1, globe2);
                    final double acc1 = force.getSize() / globe1.getMass();
                    final double acc2 = force.getSize() / globe2.getMass();

                    logger.debug("{}", force.toString());
                    logger.debug("Acc1: {}, Acc2: {}", acc1, acc2);

                    logger.debug("Old speed1: {}", globe1.getCurrentSpeed());
                    logger.debug("Old speed2: {}", globe2.getCurrentSpeed());

                    double a1x = acc1 * force.getCoordinate().getX() / force.getSize();
                    double a1y = acc1 * force.getCoordinate().getY() / force.getSize();
                    double a1z = acc1 * force.getCoordinate().getZ() / force.getSize();
                    double a2x = -1 * acc2 * force.getCoordinate().getX() / force.getSize();
                    double a2y = -1 * acc2 * force.getCoordinate().getY() / force.getSize();
                    double a2z = -1 * acc2 * force.getCoordinate().getZ() / force.getSize();

                    globe1.setCurrentSpeed(new Coordinate(globe1.getCurrentSpeed().getX() + a1x, globe1.getCurrentSpeed().getY() + a1y, globe1.getCurrentSpeed().getZ() + a1z));
                    globe2.setCurrentSpeed(new Coordinate(globe2.getCurrentSpeed().getX() + a2x, globe2.getCurrentSpeed().getY() + a2y, globe2.getCurrentSpeed().getZ() + a2z));

                    logger.debug("New speed1: {}", globe1.getCurrentSpeed());
                    logger.debug("New speed2: {}", globe2.getCurrentSpeed());




                }
            }
        }

        logger.debug("Done {}", System.currentTimeMillis());
    }

    public static Force calculateForce(final Globe g1, final Globe g2) {

        double x = g1.getPosition().getX() - g2.getPosition().getX();
        double y = g1.getPosition().getY() - g2.getPosition().getY();
        double z = g1.getPosition().getZ() - g2.getPosition().getZ();
        double distance = Math.sqrt(x*x + y*y + z*z);
        double force = Calculator.G * g1.getMass() * g2.getMass() / Math.pow(distance,2);

        return new Force(x / force, y/force, z/force);

    }

}
