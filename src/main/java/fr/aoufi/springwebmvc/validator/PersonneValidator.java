package fr.aoufi.springwebmvc.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.aoufi.springwebsample.model.Personne;

@Component
public class PersonneValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
	
		return clazz.isAssignableFrom(Personne.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Personne personne =  (Personne) target;
		
		if(personne.getNom() == null || personne.getNom().isEmpty()) {
			errors.rejectValue("nom", "nom.empty");
		}else if(personne.getNom().length()<3){
			errors.rejectValue("nom", "nom.invalid1");
		}
		else{
		   	String  expression="^[a-zA-Z]+$"; 
	            CharSequence inputStr = personne.getNom();
	            Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
	            Matcher matcher = pattern.matcher(inputStr);
	            if(!matcher.matches()){
	            	errors.rejectValue("nom", "nom.invalid2");
	            }    	
		}
	}	

}
