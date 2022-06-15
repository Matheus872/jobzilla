package com.jobzilla.model;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "TB_USER_SKILL")
@Data
public class UserSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userSkillId;

    @ManyToOne
    @JoinColumn(name = "USERID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "SKILLID", nullable = false)
    private Skill skill;

    private Integer level;
}
