package de.sea2p.klausurenService.model;


import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "klausuren")
public class Klausur {

    @Id
    private String title;

    private Binary pdf;


}
