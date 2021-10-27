package com.sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.models.State;
import com.sts.repositories.StateRepository;

@Service
public class StateService {



	@Autowired
	private StateRepository stateRepository;


	//Return list of states
	public List<State> getStates(){
		return stateRepository.findAll();
	}

	//Save new states
	public void save(State states) {
		stateRepository.save(states);
	}

	//get by id
	public Optional <State> findById(int id) {
		return stateRepository.findById(id);
	}

	//delete
	public void delete(Integer id) {
		 stateRepository.deleteById(id);

	}


}
