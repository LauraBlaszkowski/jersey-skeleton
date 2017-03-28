package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;

public class StyleDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(StyleDto.class);
    private int id = 0;
    private String couleur;
    private String police;
    private String taille;
    private String espacement_caractere;
    private String espacement_ligne;
    private String espacement_mot;

    
    public int getId() {
        return id;
    }

	public void setId(int id) {
		this.id = id;
	}

    public String getCouleur() {
		return police;
	}

	public String setCouleur(String Couleur) {
		return couleur;
	}
		    
    public String getPolice() {
		return police;
	}

	public void setPolice(String police) {
		this.police = police;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public String getEspacement_caractere() {
		return espacement_caractere;
	}

	public void setEspacement_caractere(String espacement_caractere) {
		this.espacement_caractere = espacement_caractere;
	}

	public String getEspacement_ligne() {
		return espacement_ligne;
	}

	public void setEspacement_ligne(String espacement_ligne) {
		this.espacement_ligne = espacement_ligne;
	}

	public String getEspacement_mot() {
		return espacement_mot;
	}

	public void setEspacement_mot(String espacement_mot) {
		this.espacement_mot = espacement_mot;
	}

	@Override
	public String getName() {
		return null;
	}

	

}
