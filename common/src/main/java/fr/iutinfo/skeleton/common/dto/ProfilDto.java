package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;

public class ProfilDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(ProfilDto.class);
    private String name;
    private int id = 0;
    private int proprio;
    private String description;
    private int style;


   
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

	

	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}
}
