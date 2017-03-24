package fr.iutinfo.skeleton.api;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.ProfilDto;

@Path("/profil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfilResource {
    final static Logger logger = LoggerFactory.getLogger(UserResource.class);
    private static ProfilDao dao = getDbi().open(ProfilDao.class);
    private static UserDao daoUser = getDbi().open(UserDao.class);
    
    public ProfilResource() throws SQLException {
        if (!tableExist("profils")) {
            logger.debug("Crate table profils");
            dao.createProfilTable();
            dao.insert(new Profil(0, "Profil1", "utilisateur1", "Profil de base"));
        }
    }

    @POST
    public ProfilDto createProfil(ProfilDto dto) {
        Profil profil= new Profil();
        profil.initFromDto(dto);
        System.out.println("test");
        User user = daoUser.findByName(profil.getProprio());
        if (user != null) {
        	 int id = dao.insert(profil);
             dto.setId(id);
             return dto;
        }
        return null;
    }

    @GET
    @Path("/{name}")
    public ProfilDto getProfil(@PathParam("name") String name) {
    	Profil profil = dao.findByName(name);
        if (profil == null) {
            throw new WebApplicationException(404);
        }
        return profil.convertToDto();
    }

    @GET
    public List<ProfilDto> getAllProfils(@QueryParam("q") String query) {
        List<Profil> profils;
        if (query == null) {
            profils = dao.all();
        } else {
            logger.debug("Search profils with query: " + query);
            profils = dao.search("%" + query + "%");
        }
        return profils.stream().map(Profil::convertToDto).collect(Collectors.toList());
    }

    @DELETE
    @Path("/{id}")
    public void deleteProfil(@PathParam("id") int id) {
        dao.delete(id);
    }

}
