package de.sea2p.klausurenService.dao;

import de.sea2p.klausurenService.model.Klausur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MongoService {

    @Autowired(required=false)
    KlausurenRepository klausurenRepository;

    public Klausur insertKlausurToDB(Klausur klausur){
        return this.klausurenRepository.insert(klausur);
    }

    public Klausur getKlausurByTitel(String titel){
        return this.klausurenRepository.findById(titel).orElseThrow(()-> new IllegalArgumentException("Klausur nicht gefunden!"));
    }



}