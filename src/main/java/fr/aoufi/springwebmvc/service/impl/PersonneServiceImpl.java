package fr.aoufi.springwebmvc.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.aoufi.springwebmvc.dao.PersonneDAO;
import fr.aoufi.springwebmvc.exception.PersonneNotFoundException;
import fr.aoufi.springwebmvc.service.PersonneService;
import fr.aoufi.springwebsample.model.Personne;

public class PersonneServiceImpl implements PersonneService {
	
	private PersonneDAO personneDAO;

	public PersonneDAO getPersonneDAO() {
		return personneDAO;
	}
	public void setPersonneDAO(PersonneDAO personneDAO) {
		this.personneDAO = personneDAO;
	}

	@Override
	@Transactional
	public Personne save(Personne personne) {
		personne = personneDAO.save(personne);
		return personne;
	}
	
	@Override
	public Personne findById(Integer id) {	
		return personneDAO.findOne(id);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		if(findById(id)==null){
			throw new PersonneNotFoundException("personne non trouvée");
		}
		personneDAO.delete(id);
	}
	
	@Override
	public List<Personne> findByNom(String nom) {		
		return personneDAO.findByNom(nom);
	}
	
	@Override
	public List<Personne> findAllOrderByName() {
		
		return personneDAO.findAllOrderByNom();
	}

}
