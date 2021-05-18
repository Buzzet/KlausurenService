package de.sea2p.klausurenService.model;


import lombok.Builder;
import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@Document(collection = "klausuren")
public class Klausur {

    @Id
    private String id;      //Von MongoDB automatisch vergebene MongoID
    private int semester;
    private String studiengang;
    private String jahr;
    private String modul;
    private String prof;
    private Binary pdf;


}
