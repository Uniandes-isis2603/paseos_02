/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.paseos.resources;

import co.edu.uniandes.csw.paseos.dtos.CalificacionDetailDTO;
import co.edu.uniandes.csw.paseos.ejbs.CalificacionLogic;
import co.edu.uniandes.csw.paseos.entities.CalificacionEntity;
import co.edu.uniandes.csw.paseos.exceptions.BusinessLogicException;
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
 * @author Sebastian Millan
 */
@Path("/calificaciones")
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.APPLICATION_JSON)
public class CalificacionResource 
{
    @Inject private CalificacionLogic calificacionLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page; 
    @QueryParam("limit") private Integer maxRecords; 
    
    private List<CalificacionDetailDTO> listEntity2DTO(List<CalificacionEntity> listaEntrada)
    {
        List<CalificacionDetailDTO> list = new ArrayList<>();
        for (CalificacionEntity entity : listaEntrada) {
            list.add(new CalificacionDetailDTO(entity));
        }
        return list;
        
    }
    
    @GET
    public List<CalificacionDetailDTO> getCalificaciones( )
    {
        return listEntity2DTO(calificacionLogic.getCalificaciones());
        
    }
    
    @GET
    @Path("{id: \\d+}")
    public CalificacionDetailDTO getCalificacion(@PathParam("id") Long id) 
    {
        return new CalificacionDetailDTO(calificacionLogic.getCalificacion(id));
        
    }
    
    @POST
    public CalificacionDetailDTO createCalificacion(CalificacionDetailDTO dto) throws BusinessLogicException 
    {
        return new CalificacionDetailDTO(calificacionLogic.createCalificacion(dto.toEntity()));
       
    }
    
    @PUT
    @Path("{id: \\d+}")
    public CalificacionDetailDTO updateCalificacion(@PathParam("id") Long id, CalificacionDetailDTO dto) 
    {
        CalificacionEntity entity = dto.toEntity();
        entity.setId(id);
        return new CalificacionDetailDTO(calificacionLogic.updateEmployee(entity));
        
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCalificacion(@PathParam("id") Long id)
    {
       calificacionLogic.deleteCalificacion(id);
    }
    
}
