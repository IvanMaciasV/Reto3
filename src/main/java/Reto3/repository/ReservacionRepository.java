package Reto3.repository;

import Reto3.model.Reservacion;
import Reto3.repository.crud.ReservacionCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//Creacion del repositorio de reservacion
public class ReservacionRepository {
    @Autowired
    private ReservacionCrudRepository reservationCrudRepository;

    public List<Reservacion> getAll(){return (List<Reservacion>) reservationCrudRepository.findAll();}
    public Optional<Reservacion> getReservation(int id){return reservationCrudRepository.findById(id);}
    public Reservacion save(Reservacion reservation){return reservationCrudRepository.save(reservation); }

}
