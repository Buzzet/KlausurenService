package de.sea2p.klausurenService.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class KlausurenController {

  @GetMapping("test")
  public List<String> test(){
      LinkedList<String> list = new LinkedList<>();
      list.add("Hello World 1.0");
      return list;
  }
}
