package org.cours.web;

import org.cours.modele.Voiture;
import org.cours.modele.VoitureRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class VoitureController {
    		@Autowired
    		private VoitureRepo voitureRepo;
    		
    		@RequestMapping("/voitures")
    		public Iterable<Voiture> getVoitures(){
   	 		return voitureRepo.findAll();
    		}
    		
    		@RequestMapping(method=RequestMethod.POST, value="/voitures")
    		public void ajouterModule(@RequestBody Voiture voiture) {
    			voitureRepo.save(voiture);	
    		}
    		
    		@RequestMapping(method=RequestMethod.PUT, value="/voitures/{id}")
    		public void modifierModule(@RequestBody Voiture voiture, @PathVariable Integer id) {
    			voiture.setId(id);
    			voitureRepo.save(voiture);	
    		}
    		
    		@RequestMapping(method=RequestMethod.DELETE, value="/voitures/{id}")
    		 public void supprimerModule(@PathVariable Long id) {
    				voitureRepo.deleteById(id);	
    		 }

}
