/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.paseos.resources;

import co.edu.uniandes.csw.paseos.dtos.GuiaDetailDTO;
import co.edu.uniandes.csw.paseos.ejbs.GuiaLogic;
import co.edu.uniandes.csw.paseos.entities.GuiaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

/**
 *
 * @author Juan David Vega 
 */
@Path("/guias")
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.APPLICATION_JSON)
public class GuiaResource
{
    @Inject private GuiaLogic guiaLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page; 
    @QueryParam("limit") private Integer maxRecords; 
    
    private List<GuiaDetailDTO> listEntity2DTO(List<GuiaEntity> listaEntrada)
    {
        return null;
        
    }
    
    @GET
    public List<GuiaDetailDTO> getGuiaes( )
    {
        return null;
        
    }
    
    @GET
    @Path("{id: \\d+}")
    public GuiaDetailDTO getGuia(@PathParam("id") Long id) 
    {
        return null;
        
    }
    
    @POST
    public GuiaDetailDTO createGuia(GuiaDetailDTO dto) 
    {
        return null;
       
    }
    
    @PUT
    @Path("{id: \\d+}")
    public GuiaDetailDTO updateGuia(@PathParam("id") Long id, GuiaDetailDTO dto) 
    {
        return null;
        
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteGuia(@PathParam("id") Long id)
    {
       
    }
    
    
}
