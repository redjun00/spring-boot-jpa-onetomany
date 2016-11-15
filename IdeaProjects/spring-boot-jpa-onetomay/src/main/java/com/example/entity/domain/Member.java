package com.example.entity.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seq;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Phone> phones;

    public Member(String name) {
        this.name = name;
    }

    public void addPhone(Phone p){
        if( phones == null ){
            phones = new ArrayList<Phone>();
        }
        phones.add(p);
    }
}
