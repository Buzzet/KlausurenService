package de.sea2p.klausurenService.dao;

import de.sea2p.klausurenService.model.Klausur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Component
public class MongoService {

    @Autowired
    KlausurenRepository klausurenRepository;

    public Klausur insertKlausurToDB(Klausur klausur){
        return this.klausurenRepository.insert(klausur);
    }

    public Klausur getKlausurByID(String id){
        return this.klausurenRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Klausur nicht gefunden!"));
    }


    public LinkedList<String> getAllKlausuren() {
        return null;
    }

    public HashSet<Integer> getSemester() {
        return null;
    }

    public List<Klausur> getYears(String studiengang, String modul) {
        return klausurenRepository.getKlausurByStudiengangAndModul(studiengang,modul);
    }
}
