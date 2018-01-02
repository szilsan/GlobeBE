package com.example.szilsan.model;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by szilsan on 11/07/2017.
 */
@Component
public class SimulationModel {

    private Set<Globe> globes;

    public Set<Globe> getGlobes() {
        if (globes == null) {
            globes = new HashSet<>();
        }

        return globes;
    }

    public void setGlobes(Set<Globe> globes) {
        this.globes = globes;
    }
}
