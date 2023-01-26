package com.mroxny.mtba;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private MultiplexManager multiplexManager;
    private final ObjectMapper objectMapper;


    @Autowired
    public ReservationController(MultiplexManager multiplexManager, ObjectMapper objectMapper){
        this.multiplexManager = multiplexManager;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public ResponseEntity<Reservation> makeReservation(@RequestBody String requestBody) throws IOException {
        ReservationRequest request = objectMapper.readValue(requestBody, ReservationRequest.class);
        Reservation reservation = multiplexManager.makeReservation(request);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping
    public ResponseEntity<Reservation> getReservation(@RequestParam int id){
        Reservation reservation = multiplexManager.getReservation(id);
        return ResponseEntity.ok(reservation);
    }
}
