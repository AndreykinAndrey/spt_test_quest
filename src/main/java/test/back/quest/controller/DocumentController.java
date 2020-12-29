package test.back.quest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.back.quest.model.Document;

import javax.validation.*;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @PostMapping(value = "/postDocument")
    public ResponseEntity<?> postDocument(@RequestBody @Valid Document document) {
        System.out.println(document.toString());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
