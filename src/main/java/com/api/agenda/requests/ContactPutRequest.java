package com.api.agenda.requests;

import lombok.Data;

@Data
public class ContactPutRequest {
    private Long id;
    private String name;
    private String celPhone;
    private String secondPhone;
    private String address;
}
