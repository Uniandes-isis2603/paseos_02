/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.paseos.dtos;

import co.edu.uniandes.csw.paseos.entities.CalificacionEntity;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian Millan
 */
@XmlRootElement
public class CalificacionDTO implements Serializable
{
    public CalificacionDTO( )
    {
        
    }
    
    public CalificacionDTO(CalificacionEntity entity)
    {
        if(entity != null)
        {
         
        }
    }
    
    public CalificacionEntity toEntity( )
    {
        return null;  
    }    
    
}
