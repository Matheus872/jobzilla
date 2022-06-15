package com.jobzilla.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_JOB_SKILL")
@Data
public class JobSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobSkillId;

    //@ManyToOne(cascade=CascadeType.PERSIST)
    //@JoinColumn(name="jobId")
    private Integer job;

    private Integer skillId;
}
