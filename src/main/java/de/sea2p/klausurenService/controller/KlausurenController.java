package de.sea2p.klausurenService.controller;

import com.itextpdf.text.DocumentException;
import de.sea2p.klausurenService.dao.MongoService;
import de.sea2p.klausurenService.model.Klausur;
import de.sea2p.klausurenService.model.KlausurRequest;
import de.sea2p.klausurenService.service.KlausurenService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("klausur/")
public class KlausurenController {

    @Autowired
    MongoService mongoService;

    @Autowired
    KlausurenService klausurenService;

    @CrossOrigin(origins = "*")
    @RequestMapping(
            value = "hochladen",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @ResponseBody
    public ResponseEntity<String> addKlausur(@ModelAttribute KlausurRequest request) throws IOException, DocumentException {

        String contentType = request.getFileArray().getContentType();

        if(contentType.equals("image/jpeg") || contentType.equals("application/pdf")|| contentType.equals("image/png")){

            String klausurID = klausurenService.addKlausur(request.toKlausur());
            return ResponseEntity.status(HttpStatus.OK).body("Klausur mit ID: " + klausurID + " erfolgreich Hochgeladen");

        }

        throw new IOException("Ungueltiges Dateiformat");
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "anzeigen/{id}", method = RequestMethod.GET, produces = "application/pdf")
    public void getKlausur(@PathVariable(value = "id") String id, HttpServletResponse response) throws Exception {
        Klausur klausur = klausurenService.getKlausur(id);
        try {
            byte[] pdf = klausur.getPdf().getData();

            response.setContentType("application/pdf");
            response.setContentLength(pdf.length);
            response.getOutputStream().write(pdf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @CrossOrigin()
    @GetMapping("studiengaenge")
    public Set<String> getAllStudiengaenge() {
        return mongoService.getAllStudiengaenge();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("semester/{studiengang}")
    public Set<Integer> getAllSemestersByStudiengang(@PathVariable(value = "studiengang") String studiengang) {
        return mongoService.getAllSemestersByStudiengang(studiengang);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("module/{studiengang}/{semester}")
    public Set<String> getAllModuleByStudiengangAndSemester(@PathVariable(value = "studiengang") String studiengang,
                                                            @PathVariable(value = "semester") int semester) {
        return mongoService.getAllModuleByStudiengangAndSemester(studiengang, semester);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("klausuren/{studiengang}/{semester}/{modul}")
    public List<Klausur> getAllKlausurenByStudiengangAndSemesterAndModul(@PathVariable(value = "studiengang") String studiengang,
                                                                         @PathVariable(value = "semester") int semester,
                                                                         @PathVariable(value = "modul") String modul) {
        return mongoService.getAllKlausurenByStudiengangAndSemesterAndModul(studiengang, semester, modul);
    }


}
