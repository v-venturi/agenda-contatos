package com.api.agenda.mapper;

import com.api.agenda.model.Contact;
import com.api.agenda.requests.ContactPostRequest;
import com.api.agenda.requests.ContactPutRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;



@Mapper(componentModel = "spring")
public abstract class ContactMapper {
    public static final ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    public abstract Contact toContact(ContactPostRequest contactPostRequest);

    public abstract Contact toContact(ContactPutRequest contactPutRequest);

}
