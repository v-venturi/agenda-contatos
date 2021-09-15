package com.api.agenda.requests;

import lombok.Data;

@Data
public class ContactPostRequest {

    private String name;
    private String celPhone;
    private String secondPhone;
    private String address;
}
