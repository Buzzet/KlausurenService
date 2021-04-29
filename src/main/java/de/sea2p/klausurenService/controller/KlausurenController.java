package de.sea2p.klausurenService.controller;

import de.sea2p.klausurenService.dao.KlausurenRepository;
import de.sea2p.klausurenService.dao.MongoService;
import de.sea2p.klausurenService.model.Klausur;
import lombok.Getter;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@RestController
public class KlausurenController {

    @Autowired
    MongoService mongoService;

  @GetMapping("test")
  public List<String> test(){
      LinkedList<String> list = new LinkedList<>();
      list.add("Hello World 2.0 - Welcome to the Future");
      return list;
  }

  @CrossOrigin
  @PostMapping("/test/klausurUpload")
  public String addKlausur(@RequestParam("pdf") MultipartFile file) throws IOException {
      Klausur klausur = Klausur.builder().title("title").pdf(new Binary(BsonBinarySubType.BINARY, file.getBytes())).build();
      klausur = mongoService.insertKlausurToDB(klausur);
      return klausur.getTitle();
  }

  @GetMapping("/semester")
  public HashSet<Integer> getSemester(){
      return this.mongoService.getSemester();
  }

  @CrossOrigin
  @GetMapping("/test/getKlausur/{id}")
  public Klausur getKlausur(@PathVariable(value = "id") String titel){
      return mongoService.getKlausurByTitel(titel);
  }

}
