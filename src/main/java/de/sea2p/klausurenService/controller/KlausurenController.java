package de.sea2p.klausurenService.controller;

import de.sea2p.klausurenService.dao.MongoService;
import de.sea2p.klausurenService.model.Klausur;
import de.sea2p.klausurenService.service.KlausurenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class KlausurenController {

    @Autowired
    MongoService mongoService;

    @Autowired
    KlausurenService klausurenService;

  @GetMapping("test")
  public List<String> test(){
      LinkedList<String> list = new LinkedList<>();
      list.add("Hello World 2.0 - Welcome to the Future");
      return list;
  }

  @CrossOrigin
  @RequestMapping(
          value = "/test/klausurUpload",
          method = RequestMethod.POST,
          consumes = MediaType.MULTIPART_FORM_DATA_VALUE
  )
  @ResponseBody
  public String addKlausur(@RequestParam("fileArray") MultipartFile fileArray, @RequestParam("title") String title) throws IOException {
      title = klausurenService.addKlausur(title, fileArray);
      return "Erfolgreich hochgeladen: " + title;
  }


  @GetMapping("/semester")
  public HashSet<Integer> getSemester(){
      return this.mongoService.getSemester();
  }

  @CrossOrigin(origins = "*")
  @GetMapping("/test/getKlausur/{id}")
  public Klausur getKlausur(@PathVariable(value = "id") String titel){
      return mongoService.getKlausurByTitel(titel);
  }

  public List<Klausur> getModul(String currentStudiengang, int currentSemester) {
      return null;
  }

  @CrossOrigin(origins = "*")
  @GetMapping("/years/{studiengang}/{modul}")
    public List<Klausur> getYears(@PathVariable(value = "studiengang") String studiengang,@PathVariable(value = "modul") String modul) {
      return mongoService.getYears(studiengang, modul);
    }
}
