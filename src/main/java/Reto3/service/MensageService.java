package Reto3.service;

import Reto3.model.Mensage;
import Reto3.repository.MensageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//creacion del servicio Mensaje
@Service
public class MensageService {
    @Autowired
    private MensageRepository messageRepository;

    public List<Mensage> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Mensage> getMessage(int idMessage){
        return messageRepository.getMessage(idMessage);
    }

    public Mensage save(Mensage message) {
        if(message.getIdMessage()== null){
            return messageRepository.save(message);

        }else{
            Optional<Mensage>messageAux=messageRepository.getMessage(message.getIdMessage());
            if(messageAux.isEmpty()) {
                return messageRepository.save(message);
            }else{
                return message;
            }

        }
    }
    public Mensage update (Mensage m){
        if(m.getIdMessage()!=null){
            Optional<Mensage>g=messageRepository.getMessage(m.getIdMessage());
            if(!g.isEmpty()){
                if(m.getMessageText()!=null){
                    g.get().setMessageText(m.getMessageText());
                }

                return messageRepository.save(g.get());
            }else{
                return m;
            }
        }else{
            return m;
        }
    }

    public boolean deleteMensage(int id){
        Boolean d=getMessage(id).map(mensage ->{
            messageRepository.delete(mensage);
            return true;
        }).orElse(false);
        return d;
    }

}
