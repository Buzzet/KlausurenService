package de.sea2p.klausurenService.dao;

import de.sea2p.klausurenService.model.Klausur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KlausurenRepository extends MongoRepository<Klausur, String> {

    List<Klausur> getKlausurByStudiengangAndSemester(String studiengang, int semester);
    List<Klausur> getKlausurByStudiengangAndModul(String studiengang ,String modul);

}
