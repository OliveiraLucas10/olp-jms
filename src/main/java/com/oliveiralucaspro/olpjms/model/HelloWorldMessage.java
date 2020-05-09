package com.oliveiralucaspro.olpjms.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HelloWorldMessage implements Serializable {

    private static final long serialVersionUID = -7455243351114159262L;
    
    private UUID id;
    private String message;

}
