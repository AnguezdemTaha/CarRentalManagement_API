package org.cours.modele;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Voiture {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
	
@NonNull
private String marque;
@NonNull
private String modele;
@NonNull
private String couleur;
@NonNull
private String immatricule; 
@NonNull
private int annee;
@NonNull
private int prix;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "proprietaire")
@NonNull
@JsonIgnore
private Proprietaire proprietaire;

}
