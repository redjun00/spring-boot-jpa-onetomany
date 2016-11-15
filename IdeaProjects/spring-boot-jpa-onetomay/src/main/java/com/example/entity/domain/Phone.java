package com.example.entity.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seq;

    private String no;

    @Column(name = "member_id")
    private int memberId;

    public Phone(String no){
        this.no = no;
    }
}
