package fr.aoufi.springwebmvc.service;

import java.util.List;

import fr.aoufi.springwebsample.model.Personne;

public interface PersonneService {
	
	Personne save(Personne personne);
	
	Personne findById(Integer id);
	
	List<Personne> findByNom(String nom);
	
	List<Personne> findAllOrderByName();
	
	void delete(Integer id);

}
