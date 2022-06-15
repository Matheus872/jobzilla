package com.jobzilla.repository;

import com.jobzilla.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobRepository extends JpaRepository<Job, Integer> {

}
