package de.sea2p.klausurenService.model;

import lombok.Data;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.IOException;

@Data
public class KlausurRequest {

    @Size(min = 1, max = 1)
    @NotNull
    private int semester;
    @NotNull
    private String studiengang;
    @NotNull
    private String jahr;
    @NotNull
    private String modul;
    //Wofür brauchen wir den Prof?
    private String prof;
    @NotNull
    private MultipartFile fileArray;
    @NotNull
    private String uploadedFrom;

    public Klausur toKlausur() throws IOException {
        return Klausur.builder()
                .jahr(jahr)
                .modul(modul)
                .pdf(new Binary(BsonBinarySubType.BINARY, fileArray.getBytes()))
                .prof(prof)
                .semester(semester)
                .studiengang(studiengang)
                .build();
    }
}