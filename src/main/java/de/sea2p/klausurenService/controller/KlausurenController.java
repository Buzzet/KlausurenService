package de.sea2p.klausurenService.controller;

import de.sea2p.klausurenService.dao.MongoService;
import de.sea2p.klausurenService.model.Klausur;
import de.sea2p.klausurenService.service.KlausurenService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("klausur/")
public class KlausurenController {

    @Autowired
    MongoService mongoService;

    @Autowired
    KlausurenService klausurenService;

    @GetMapping("test")
    public List<String> test() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Hello World 2.0 - Welcome to the Future");
        return list;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(
            value = "hochladen",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @ResponseBody
    public ResponseEntity<String> addKlausur(
            @RequestParam("semester") int semester,
            @RequestParam("studiengang") String studiengang,
            @RequestParam("jahr") String jahr,
            @RequestParam("modul") String modul,
            @RequestParam("prof") String prof,
            @RequestParam("fileArray") MultipartFile fileArray
    ) throws IOException {
        String klausurID = klausurenService.addKlausur(semester, studiengang, jahr, modul, prof, fileArray);
        return ResponseEntity.status(HttpStatus.OK).body("Klausur mit ID: "+ klausurID +" erfolgreich Hochgeladen");
    }


    @GetMapping("/semester")
    public HashSet<Integer> getSemester() {
        return this.mongoService.getSemester();
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

    public List<Klausur> getModul(String currentStudiengang, int currentSemester) {
        return null;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/years/{studiengang}/{modul}")
    public List<Klausur> getYears(@PathVariable(value = "studiengang") String studiengang, @PathVariable(value = "modul") String modul) {
        return mongoService.getYears(studiengang, modul);
    }
}
