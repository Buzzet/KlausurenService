package de.sea2p.klausurenService.service;

import de.sea2p.klausurenService.dao.MongoService;
import de.sea2p.klausurenService.model.Klausur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KlausurenService {

    @Autowired
    MongoService mongoService;

    public String addKlausur(Klausur klausur) throws IOException {
        klausur = mongoService.insertKlausurToDB(klausur);
        return klausur.getId();
    }

    public Klausur getKlausur(String id) {
        return mongoService.getKlausurByID(id);
    }
}
