package co.usa.ciclo3.reto5.web;

import co.usa.ciclo3.reto5.model.Farm;
import co.usa.ciclo3.reto5.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class FarmController {

    @Autowired
    private FarmService farmService;
    @GetMapping("/all")
    public List<Farm> getFarms() {
        return farmService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Farm> getFarm(@PathVariable("id") int idFinca) {
        return farmService.getFarm(idFinca);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm save(@RequestBody Farm f) {
        return farmService.save(f);
    }
}
