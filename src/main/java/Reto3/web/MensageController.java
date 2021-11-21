package Reto3.web;

import Reto3.model.Mensage;
import Reto3.service.MensageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class MensageController {
    @Autowired
    private MensageService mensageService;

    @GetMapping("/all")
    public List<Mensage> getMessage() {
        return mensageService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Mensage> getMessage(@PathVariable("id") int idMessage) {
        return mensageService.getMessage(idMessage);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensage save(@RequestBody Mensage message) {
        return mensageService.save(message);
    }

}