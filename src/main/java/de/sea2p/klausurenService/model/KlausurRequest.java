package de.sea2p.klausurenService.model;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.Data;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.*;

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

    public Klausur toKlausur() throws IOException, DocumentException {
        return Klausur.builder()
                .jahr(jahr)
                .modul(modul)
                .pdf(new Binary(BsonBinarySubType.BINARY, getPDF()))
                .prof(prof)
                .semester(semester)
                .studiengang(studiengang)
                .build();
    }

    //
    private byte[] getPDF() throws IOException, DocumentException {
        if(fileArray.getContentType().equals("image/jpeg") || fileArray.getContentType().equals("image/png")){
            Document pdfDoc = new Document();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                PdfWriter writer = PdfWriter.getInstance(pdfDoc, out);
                writer.open();
                pdfDoc.open();
                pdfDoc.add(Image.getInstance(fileArray.getBytes()));
                pdfDoc.close();
                writer.close();
                return out.toByteArray();
        }
        else{
            return  fileArray.getBytes();
        }
    }
}
