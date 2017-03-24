package fr.iutinfo.skeleton.api;

import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.iutinfo.skeleton.common.dto.ProfilDto;

public class Profil implements Principal {
    final static Logger logger = LoggerFactory.getLogger(Profil.class);
    private static Profil anonymous = new Profil(-1, "Basic", -1, "");
    private String name;
    private int id = 0;
    private int proprio;
    private String description;
    private String search;


    public Profil(int id, String name, int proprio, String description) {
    	this.id=id;
    	this.name=name;
    	this.proprio=proprio;
    	this.description=description;
	}


    public Profil() {
	}


	public static Profil getAnonymousProfil() {
        return anonymous;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

	public int getProprio() {
		return proprio;
	}


	public void setProprio(int proprio) {
		this.proprio = proprio;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
    public String getSearch() {
        search = name + " " + proprio;
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }


    @Override
    public boolean equals(Object arg) {
        if (getClass() != arg.getClass())
            return false;
        Profil profil = (Profil) arg;
        return id==profil.getId(); 
    }

    @Override
    public String toString() {
        return id + ": "+ name + ", " + proprio + ", " + description;
    }




    public void initFromDto(ProfilDto dto) {
        this.setId(dto.getId());
        this.setName(dto.getName());
        this.setProprio(dto.getProprio());
        this.setDescription(dto.getDescription());
    }

    public ProfilDto convertToDto() {
        ProfilDto dto = new ProfilDto();
        dto.setId(this.getId());
        dto.setName(this.getName());
        dto.setProprio(this.getProprio());
        dto.setDescription(this.getDescription());
        return dto;
    }


}
