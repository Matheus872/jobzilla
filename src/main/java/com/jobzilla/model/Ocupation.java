package com.jobzilla.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_OCUPATION")
@Data
public class Ocupation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ocupationId;
    private String name;
}
