package com.jobzilla.dto.request.job;

import com.jobzilla.model.Skill;
import lombok.Data;

import java.util.List;

@Data
public class JobRegisterRequestDto {
    private String title;
    private String subtitle;
    private String experience;
    private String workJourney;
    private String local;
    private String salary;
    private String benefits;
    private String description;
    private List<Integer> skills;
}
