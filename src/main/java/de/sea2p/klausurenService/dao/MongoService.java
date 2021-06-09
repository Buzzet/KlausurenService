package de.sea2p.klausurenService.dao;

import de.sea2p.klausurenService.model.Klausur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    /*
    public List<String> getAllKlausuren() {
        return null;
    }

    public HashSet<Integer> getSemester() {
        return null;
    }

    public List<Klausur> getYears(String studiengang, String modul) {
        return klausurenRepository.getKlausurByStudiengangAndModul(studiengang,modul);
    }

     */

    public Set<String> getAllStudiengaenge(){
        return klausurenRepository.findAll().stream().map(klausur -> klausur.getStudiengang()).collect(Collectors.toSet());
    }

    public Set<Integer> getAllSemestersByStudiengang(String studiengang){
        return klausurenRepository.getAllByStudiengang(studiengang).stream().map(klausur -> klausur.getSemester()).collect(Collectors.toSet());
    }

    public Set<String> getAllModuleByStudiengangAndSemester(String studiengang, int semester){
        return klausurenRepository.getKlausurByStudiengangAndSemester(studiengang, semester).stream().map(klausur -> klausur.getModul()).collect(Collectors.toSet());
    }

    public List<Klausur> getAllKlausurenByStudiengangAndSemesterAndModul(String studiengang, int semester, String modul){
        return klausurenRepository.getAllByStudiengangAndSemesterAndModul(studiengang, semester, modul).stream().map(klausur -> Klausur.builder().jahr(klausur.getJahr()).id(klausur.getId()).build()).collect(Collectors.toList());
    }
}
