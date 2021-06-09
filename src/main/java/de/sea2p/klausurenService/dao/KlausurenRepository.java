package de.sea2p.klausurenService.dao;

import de.sea2p.klausurenService.model.Klausur;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface KlausurenRepository extends MongoRepository<Klausur, String> {

    List<Klausur> getKlausurByStudiengangAndSemester(String studiengang, int semester);
    List<Klausur> getKlausurByStudiengangAndModul(String studiengang ,String modul);

    List<Klausur> getAllByStudiengang(String studiengang);
    List<Klausur> getAllByStudiengangAndSemesterAndModul(String studiengang, int semester, String modul);


}
