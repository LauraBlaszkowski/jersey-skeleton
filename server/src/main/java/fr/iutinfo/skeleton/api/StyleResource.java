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

import fr.iutinfo.skeleton.common.dto.StyleDto;

@Path("/style")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StyleResource {
    final static Logger logger = LoggerFactory.getLogger(UserResource.class);
    private static StyleDao dao = getDbi().open(StyleDao.class);
    
    
    public StyleResource() throws SQLException {
        if (!tableExist("styles")) {
            logger.debug("Crate table styles");
            dao.createStyleTable();
        }
    }
    @POST
    public StyleDto createStyle(StyleDto dto) {
        Style style= new Style();
        style.initFromDto(dto);
        Style style2=dao.find(style);
 
        if (style2 == null) {
        	 int id = dao.insert(style);
             dto.setId(id);
             return dto;
        }
        return style2.convertToDto();
    }

    @GET
    public List<StyleDto> getAllStyles(@QueryParam("q") String query) {
        List<Style> styles;
        if (query == null) {
            styles = dao.all();
        } else {
            logger.debug("Search profils with query: " + query);
            styles = dao.search("%" + query + "%");
        }
        return styles.stream().map(Style::convertToDto).collect(Collectors.toList());
    }
    
    @GET
    @Path("/{id}")
    public StyleDto getUser(@PathParam("id") String id) {
        Style style = dao.findById(""+id);
        if (style == null) throw new WebApplicationException(404);
        return style.convertToDto();
    }

    @DELETE
    @Path("/{id}")
    public void deleteStyle(@PathParam("id") int id) {
        dao.delete(id);
    }

}
