package org.cours;
import static org.assertj.core.api.Assertions.assertThat;

import org.cours.modele.Proprietaire;
import org.cours.modele.Voiture;
import org.cours.modele.VoitureRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@DataJpaTest
//Si le test concerne uniquement les composantes JPA
//Lorsque cette annotation est utilisée, H2, Hibernate et Spring Data sont configurés //automatiquement pour le test.
public class VoitureRepoTest {
@Autowired
    		private TestEntityManager entityManager;
		//TestEntityManager est utilisée pour manipuler les entités persistantes
    		@Autowired
    		VoitureRepo voitureRepo;
    		@Test
    		public void ajouterVoiture() {
   	 	Voiture voiture = new Voiture ();
   	 	voiture.setPrix(999999);
   	 	entityManager.persistAndFlush(voiture);
		//permet de faire persister ce tuple de l’entité Voiture
   	 	assertThat(voiture.getId()).isNotNull();
		//permet de tester qu'un tuple de Voiture a bien été ajoutée en mémoire H2
    		}
    		@Test
    		public void supprimerVoiture() {
    			Proprietaire proprietaire1 = new Proprietaire("Ali" , "Hassan");
    			Voiture voiture1 = new Voiture ();
    	   	 	voiture1.setPrix(888888);
    	   	 	Voiture voiture2 = new Voiture ();
    	   	 	voiture2.setPrix(999999);
    			entityManager.persistAndFlush(voiture1);
    			entityManager.persistAndFlush(voiture2);
		   	 	voitureRepo.deleteAll();
		   	 	assertThat(voitureRepo.findAll()).isEmpty();
				//permet de tester si tous les tuples ont été supprimés
    		}
}
