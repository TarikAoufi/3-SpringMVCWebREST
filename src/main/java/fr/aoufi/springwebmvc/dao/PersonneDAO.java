package fr.aoufi.springwebmvc.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.aoufi.springwebsample.model.Personne;

public interface PersonneDAO extends JpaRepository<Personne, Integer> {
	
	
	@Query("select p from Personne p where p.nom=:nom")
	List<Personne> findByNom2(@Param("nom") String nom) throws DataAccessException;
	
	// spring va créer la requête pour chercher le nom de personne
	List<Personne> findByNom(String nom) throws DataAccessException;
	
	@Query("SELECT p FROM Personne p ORDER BY p.nom DESC")
	List<Personne> findAllOrderByNom() throws DataAccessException;
	
	void delete(Integer id) throws DataAccessException;
	

}
