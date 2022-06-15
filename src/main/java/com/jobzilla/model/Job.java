package com.jobzilla.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_JOB")
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer jobId;

    private String title;
    private String subtitle;
    private String experience;
    private String workJourney;
    private String local;
    private String salary;
    private String benefits;
    private String description;

}
