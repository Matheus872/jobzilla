package com.jobzilla.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_SKILL")
@Data
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer skillId;
    private String name;

}
