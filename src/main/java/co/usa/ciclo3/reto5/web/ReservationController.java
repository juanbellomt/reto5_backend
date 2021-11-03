package co.usa.ciclo3.reto5.web;

import co.usa.ciclo3.reto5.model.Reservation;
import co.usa.ciclo3.reto5.model.custom.CountClient;
import co.usa.ciclo3.reto5.model.custom.StatusAmount;
import co.usa.ciclo3.reto5.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId){
        return reservationService.getReservation(reservationId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r){
        return reservationService.save(r);
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDatesReport(@PathVariable("dateOne") String d1, @PathVariable("dateTwo") String d2 ) {
        return reservationService.getReservationPeriod(d1, d2);
    }

    @GetMapping("/report-status")
    public StatusAmount getReservationStatus() {
        return reservationService.getStatusReport();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getCountClient() {
        return reservationService.getTopClients();
    }

}