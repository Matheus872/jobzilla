package com.jobzilla.service;

import com.jobzilla.dto.request.job.JobRegisterRequestDto;
import com.jobzilla.model.Job;
import com.jobzilla.model.JobSkill;
import com.jobzilla.repository.JobRepository;
import com.jobzilla.repository.JobSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobSkillRepository jobSkillRepository;

    public void jobRegister(JobRegisterRequestDto request){
//        if (request.isNullOrEmpty()) {
//            throw new InvalidDataException();
//        }
//        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
//            throw new ExistingEmailException();
//        }

        Job job = new Job();
        job.setTitle(request.getTitle());
        job.setSubtitle(request.getSubtitle());
        job.setExperience(request.getExperience());
        job.setWorkJourney(request.getWorkJourney());
        job.setLocal(request.getLocal());
        job.setSalary(request.getSalary());
        job.setBenefits(request.getBenefits());
        job.setDescription(request.getDescription());
        jobRepository.save(job);

        JobSkill jobSkill = new JobSkill();
        List<JobSkill> jobSkills = new ArrayList<JobSkill>();
        for(Integer n: request.getSkills()) {
            jobSkill.setJob(job.getJobId());
            jobSkill.setSkillId(n);
            jobSkills.add(jobSkill);

        }
        jobSkillRepository.saveAll(jobSkills);
    }
}
