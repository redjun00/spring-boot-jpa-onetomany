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
    @JoinColumn(name = "member_id")
    private int seq;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Phone> phone;

    public Member(String name) {
        this.name = name;
    }

    public void addPhone(Phone p){
        if( phone == null ){
            phone = new ArrayList<Phone>();
        }
        phone.add(p);
    }
}
