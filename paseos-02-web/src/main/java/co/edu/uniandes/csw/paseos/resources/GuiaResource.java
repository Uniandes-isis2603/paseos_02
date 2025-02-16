/* 
 * The MIT License
 *
 * Copyright 2017 Treamwork - Team software development - Los Andes University
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.edu.uniandes.csw.paseos.resources;

import co.edu.uniandes.csw.paseos.dtos.GuiaDetailDTO;
import co.edu.uniandes.csw.paseos.ejbs.GuiaLogic;
import co.edu.uniandes.csw.paseos.entities.GuiaEntity;
import co.edu.uniandes.csw.paseos.exceptions.BusinessLogicException;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author María del Rosario León
 */
@Path("/guias")
@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.APPLICATION_JSON)
public class GuiaResource
{
    @Inject private GuiaLogic guiaLogic;
      // TODO eliminar los atributos que no se necesitan
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page; 
    @QueryParam("limit") private Integer maxRecords;

    /**
     * Convierte una lista de guíaEntity a una lista de guíaDTO
     * @param listaEntrada
     * @return lista de entities
     */
    private List<GuiaDetailDTO> listEntity2DTO(List<GuiaEntity> listaEntrada)
    {
        List<GuiaDetailDTO> l = new ArrayList<>( );
        for(GuiaEntity entity : listaEntrada)
        {
            l.add(new GuiaDetailDTO(entity));
        }
        return l;  
        
    }

    /**
     * Obtiene todos los guía
     * @return lista de los guía
     */
    @GET
    public List<GuiaDetailDTO> getGuias( )
    {
        return listEntity2DTO(guiaLogic.getGuias());
    }

    /**
     * Obtener un guía dado por parámetro
     * @param id del guía que se quiere obtener
     * @return guía dada por parámetro
     */
    @GET
    @Path("{id: \\d+}")
    public GuiaDetailDTO getGuia(@PathParam("id") Long id)  throws BusinessLogicException
    {
        if (guiaLogic.getGuia(id) == null)
        {
            throw new WebApplicationException("El guía no existe", 404);
        }
        else
            {
            return new GuiaDetailDTO(guiaLogic.getGuia(id));
        }
    }

    /**
     * Crea un guía
     * @param dto instancia del guía que se quiere crear.
     * @return nueva instancia creada.
     */
    @POST
    public GuiaDetailDTO createGuia(GuiaDetailDTO dto) throws Exception
    {
        return new GuiaDetailDTO(guiaLogic.createGuia(dto.toEntity()));
    }

    /**
     * Modifica la informacion de un guía
     * @param id id del guía que se quiere modificar
     * @param dto guía que se quiere modificar
     * @return guía con la información actualizada
     */
    @PUT
    @Path("{id: \\d+}")
    public GuiaDetailDTO updateGuia(@PathParam("id") Long id, GuiaDetailDTO dto) throws BusinessLogicException
    {
        if (guiaLogic.getGuia(id) == null)
        {
            throw new WebApplicationException("El guía no existe", 404);
        }
        else
        {
            GuiaEntity guia = dto.toEntity();
            guia.setId(id);
            return new GuiaDetailDTO(guiaLogic.updateGuia(guia));
        }

    }

    /**
     * Elimina un guía dado por parametro.
     * @param id del guía a borrar.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteGuia(@PathParam("id") Long id) throws BusinessLogicException
    {
        if (guiaLogic.getGuia(id) == null)
        {
            throw new WebApplicationException("El guía no existe", 404);
        }
        else
        {
            guiaLogic.deleteGuia(id);
        }
    }
    
    @Path("{idGuia: \\d+}/calificaciones")
    public Class<CalificacionResource> getCalificacionResource(@PathParam("idGuia") Long idGuia) {
         GuiaEntity entity = guiaLogic.getGuia(idGuia);
        if (entity == null) {
            throw new WebApplicationException("La calificación no existe", 404);
        }
        return CalificacionResource.class;
    }



}
