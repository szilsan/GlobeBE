package com.example.szilsan;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by szilsan on 18/06/2017.
 */
@RestController
public class GlobeController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/adding/")
    public String adding() {
        return "Adding result: ";
    }

    @RequestMapping("/positions")
    public PositionsDTO positions() {
        System.out.println("Request at " + System.currentTimeMillis());
        GlobeDTO globeDTO1 = new GlobeDTO(System.currentTimeMillis()%10,1 + System.currentTimeMillis()%10,2 + System.currentTimeMillis()%10,3 + System.currentTimeMillis()%10);
        GlobeDTO globeDTO2 = new GlobeDTO(System.currentTimeMillis()%5,1 + System.currentTimeMillis()%5,2 + System.currentTimeMillis()%5,3 + System.currentTimeMillis()%10);
        GlobeDTO globeDTO3 = new GlobeDTO(System.currentTimeMillis()%12,1 + System.currentTimeMillis()%12,2 + System.currentTimeMillis()%12,3 + System.currentTimeMillis()%10);
        PositionsDTO positionsDTO = new PositionsDTO();
        positionsDTO.getPositions().add(globeDTO1);
        positionsDTO.getPositions().add(globeDTO2);
        positionsDTO.getPositions().add(globeDTO3);

        return positionsDTO;
    }


}