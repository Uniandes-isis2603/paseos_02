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
 * @author Sebastián Millán
 */
@Path("/calificaciones")
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.APPLICATION_JSON)
public class CalificacionResource 
{
    @Inject private CalificacionLogic calificacionLogic;
    // TODO eliminar los atributos que no se necesitan
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page; 
    @QueryParam("limit") private Integer maxRecords; 
    
    /**
     * Convierte una lista de CalififcacionEntity a una lista de CalificacionDetailDTO
     * @param listaEntrada
     * @return Lista de entities
     */
    private List<CalificacionDetailDTO> listEntity2DTO(List<CalificacionEntity> listaEntrada)
    {
        List<CalificacionDetailDTO> list = new ArrayList<>();
        for (CalificacionEntity entity : listaEntrada) {
            list.add(new CalificacionDetailDTO(entity));
        }
        return list;
        
    }
    
    /**
     * Obtiene todas las calificaciones
     * @return Lista de calificaciones
     */
    @GET
    public List<CalificacionDetailDTO> getCalificaciones( )
    {
        return listEntity2DTO(calificacionLogic.getCalificaciones());
        
    }
    
    /**
     * Obtener una calificacion dada por parámetro
     * @param id de la calificacion que se quiere obtener
     * @return La calificacion dada por parámetro
     */
    @GET
    @Path("{id: \\d+}")
    public CalificacionDetailDTO getCalificacion(@PathParam("id") Long id) 
    {   // TODO si la calificación con el id dado no existe debe disparar una exception WebApplicationException 404
        return new CalificacionDetailDTO(calificacionLogic.getCalificacion(id));
        
    }
    
    /**
     * Crea una calificación
     * @param dto instancia de calificación que se quiere crear.
     * @return Nueva instancia creada.
     */
    @POST
    public CalificacionDetailDTO createCalificacion(CalificacionDetailDTO dto) throws BusinessLogicException 
    {
        return new CalificacionDetailDTO(calificacionLogic.createCalificacion(dto.toEntity()));
       
    }
    
    /**
     * Modifica la informacion de una calificación
     * @param id id de la calificación que se quiere modificar
     * @param dto calificación que se quiere modificar
     * @return Calificación con la información actualizada
     */
    @PUT
    @Path("{id: \\d+}")
    public CalificacionDetailDTO updateCalificacion(@PathParam("id") Long id, CalificacionDetailDTO dto) 
    {  // TODO si la calificación con el id dado no existe debe disparar una exception WebApplicationException 404
        CalificacionEntity entity = dto.toEntity();
        entity.setId(id);
        return new CalificacionDetailDTO(calificacionLogic.updateEmployee(entity));
        
    }
    
    /**
     * Elimina una Calificación dada por parámetro.
     * @param id de la calificación a borrar.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCalificacion(@PathParam("id") Long id)
    {  // TODO si la calificación con el id dado no existe debe disparar una exception WebApplicationException 404
       calificacionLogic.deleteCalificacion(id);
    }
    
}
