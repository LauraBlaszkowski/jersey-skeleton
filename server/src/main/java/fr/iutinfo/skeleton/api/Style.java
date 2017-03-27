package fr.iutinfo.skeleton.api;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.StyleDto;

public class Style implements Principal {
    final static Logger logger = LoggerFactory.getLogger(Style.class);

    private int id = 0;
    private String couleur;
    private String police;
    private String taille;
    private String espacement_caractere;
    private String espacement_ligne;
    private String espacement_mot;


    public Style(int id, String couleur, String police, String taille, String espacement_caractere, String espacement_ligne, String espacement_mot) {
    	this.id=id;
    	this.couleur=couleur;
    	this.setPolice(police);
    	this.setTaille(taille);
    	this.setEspacement_caractere(espacement_caractere);
    	this.setEspacement_ligne(espacement_ligne);
    	this.setEspacement_mot(espacement_mot);       
    }

    public Style() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    @Override
    public boolean equals(Object arg) {
        if (getClass() != arg.getClass())
            return false;
        Style profil = (Style) arg;
        return id==profil.getId(); 
    }

    @Override
    public String toString() {
        return id + ": "+ couleur + ", " + police + ", " + taille + ", " + espacement_caractere + ", " + espacement_ligne + ", " + espacement_mot;
    }




    public void initFromDto(StyleDto dto) {
        this.setId(dto.getId());
        this.setCouleur(dto.getCouleur());
        this.setPolice(dto.getPolice());
        this.setTaille(dto.getTaille());
        this.setEspacement_caractere(dto.getEspacement_caractere());
        this.setEspacement_ligne(dto.getEspacement_ligne());
        this.setEspacement_mot(dto.getEspacement_mot());
        }

    public StyleDto convertToDto() {
        StyleDto dto = new StyleDto();
        dto.setId(this.getId());
        dto.setCouleur(this.getCouleur());
        dto.setPolice(this.getPolice());
        dto.setTaille(this.getTaille());
        dto.setEspacement_caractere(this.getEspacement_caractere());
        dto.setEspacement_ligne(this.getEspacement_ligne());
        dto.setEspacement_mot(this.getEspacement_mot());
        return dto;
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
		// TODO Auto-generated method stub
		return null;
	}


}
