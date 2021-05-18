package de.sea2p.klausurenService.service;

import de.sea2p.klausurenService.dao.MongoService;
import de.sea2p.klausurenService.model.Klausur;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class KlausurenService {

    @Autowired
    MongoService mongoService;

    public String addKlausur(int semester, String studiengang, String jahr, String modul, String prof, MultipartFile file) throws IOException {

        Klausur klausur = Klausur.builder().semester(semester).studiengang(studiengang).jahr(jahr).modul(modul).prof(prof).build();

        klausur.setPdf(
                new Binary(BsonBinarySubType.BINARY, file.getBytes())
        );


        klausur = mongoService.insertKlausurToDB(klausur);
        return  klausur.getId();
    }

    public Klausur getKlausur(String id){
        return mongoService.getKlausurByID(id);
    }
}
