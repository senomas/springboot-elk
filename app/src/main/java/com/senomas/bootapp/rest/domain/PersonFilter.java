package com.senomas.bootapp.rest.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonFilter {

    private String firstName;

    private String lastName;

    private String middleName;

    private Date dateOfBirthStart;
    
    private Date dateOfBirthEnd;
    
}