package com.sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.models.JobTitle;
import com.sts.models.Location;
import com.sts.repositories.JobTitleRepository;
import com.sts.repositories.LocationRepository;

@Service
public class JobTitleService {


	@Autowired
	private JobTitleRepository jobTitleRepository;


	//Return list of jobTitles
	public List<JobTitle> getJobTitles(){
		return jobTitleRepository.findAll();
	}

	//Save new jobTitles
	public void save(JobTitle jobTitles) {
		jobTitleRepository.save(jobTitles);
	}

	//get by id
	public Optional <JobTitle> findById(int id) {
		return jobTitleRepository.findById(id);
	}

	//delete
	public void delete(Integer id) {
		jobTitleRepository.deleteById(id);

	}
}
