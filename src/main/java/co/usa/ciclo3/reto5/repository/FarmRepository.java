package co.usa.ciclo3.reto5.repository;

import co.usa.ciclo3.reto5.model.Farm;
import co.usa.ciclo3.reto5.repository.crud.FarmCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FarmRepository {

    @Autowired
    private FarmCrudRepository farmCrudRepository;

    public List<Farm> getAll() {
        return (List<Farm>)farmCrudRepository.findAll();
    }
    public Optional<Farm> getFarm(int id) {
        return farmCrudRepository.findById(id);
    }
    public Farm save(Farm f) {
        return farmCrudRepository.save(f);
    }
}