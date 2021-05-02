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

    public String addKlausur(String title, MultipartFile file) throws IOException {
        Klausur klausur = Klausur.builder().title(title).build();

        klausur.setPdf(
                new Binary(BsonBinarySubType.BINARY, file.getBytes())
        );


        klausur = mongoService.insertKlausurToDB(klausur);
        return  klausur.getTitle();
    }

    public Klausur getKlausur(String title){
        return mongoService.getKlausurByTitel(title);
    }
}
