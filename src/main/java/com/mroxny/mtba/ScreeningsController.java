package com.mroxny.mtba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class ScreeningsController {

    private MultiplexManager multiplexManager;

    @Autowired
    public ScreeningsController(MultiplexManager multiplexManager) {
        this.multiplexManager = multiplexManager;
    }

    @GetMapping("/allScreenings")
    public ResponseEntity<List<Screening>> getAllScreenings(){
        List<Screening> screenings = multiplexManager.listAllScreenings();
        return ResponseEntity.ok(screenings);
    }

    @GetMapping("/screenings")
    public ResponseEntity<List<Screening>> getScreenings(@RequestParam LocalDate day, @RequestParam LocalTime startTime, @RequestParam LocalTime endTime){
        List<Screening> screenings = multiplexManager.listScreenings(day,startTime,endTime);
        return ResponseEntity.ok(screenings);
    }

    @GetMapping("/screening")
    public ResponseEntity<ScreeningResponse> getScreening(@RequestParam int id){
        Screening screening = multiplexManager.getScreening(id);
        int room = screening.getScreeningRoom();
        ScreeningResponse sr = new ScreeningResponse(room, multiplexManager.getRoom(room).getAvailableSeats());
        return ResponseEntity.ok(sr);
    }


}
