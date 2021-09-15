package com.api.agenda.service;

import com.api.agenda.mapper.ContactMapper;
import com.api.agenda.model.Contact;
import com.api.agenda.repository.ContactRepository;
import com.api.agenda.requests.ContactPostRequest;
import com.api.agenda.requests.ContactPutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;

    public List<Contact> listAll() {
        return contactRepository.findAll();
    }

    public Contact findById(long id) {
        return contactRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não Encontrado"));
    }

    public Contact save(ContactPostRequest contactPostRequest) {
        return contactRepository.save(ContactMapper.INSTANCE.toContact(contactPostRequest));
    }

    public void delete(long id) {
        contactRepository.delete(findById(id));
    }

    public void replace(ContactPutRequest contactPutRequest) {
        Contact savedContact = findById(contactPutRequest.getId());
        Contact contact = ContactMapper.INSTANCE.toContact(contactPutRequest);
        contact.setId(savedContact.getId());
        contactRepository.save(contact);

    }
}


