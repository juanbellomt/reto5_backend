package co.usa.ciclo3.reto5.repository.crud;

import co.usa.ciclo3.reto5.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    //JPQL
    @Query ("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationByClient();

    //QUERY METHODS
    //SELECT * FROM Reservation Where startDate > dateOne AND starDate < dateTwo
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    //SELECT * FROM Reservation WHERE description LIKE description
    public List<Reservation> findAllByStatus(String status);

}