package com.api.agenda.controller;

import com.api.agenda.model.Contact;
import com.api.agenda.repository.ContactRepository;
import com.api.agenda.requests.ContactPostRequest;
import com.api.agenda.requests.ContactPutRequest;
import com.api.agenda.service.ContactService;
import com.api.agenda.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("contatos")
@RequiredArgsConstructor
@Log4j2
public class ContactController {

    @Autowired
    private final ContactService contactService;
    private final DateUtil dateUtil;


    @GetMapping
    public ResponseEntity <List<Contact>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
       return ResponseEntity.ok(contactService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Contact>findById(@PathVariable Long id){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(contactService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Contact> save (@RequestBody ContactPostRequest contactPostRequest) {
        return new ResponseEntity<>(contactService.save(contactPostRequest), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable long id){
        contactService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace (@RequestBody ContactPutRequest contactPutRequest){
        contactService.replace(contactPutRequest);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
