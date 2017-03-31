/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.paseos.dtos;

import co.edu.uniandes.csw.paseos.entities.LugarEntity;
import co.edu.uniandes.csw.paseos.entities.PaseoEcologicoEntity;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrea Lopez
 */
@XmlRootElement
public class LugarDTO implements Serializable
{
    /*
    *Atributo del id
    */
    private Long id;
    /*
    *Atributo del nombre
    */
    private String nombre;
    /*
    *Atributo de la dirreccion
    */
    private String direccion;
    /*
    *Atributo del info ACCESO
    */
    private String linkGoogleMaps;
    /*
    *Atributo de la imagen
    */
    private String imagen;
    
    /*
    inicializador
    */
     public LugarDTO( )
    {
        
    }
     /*
    inicializador
    */
    public LugarDTO(LugarEntity entity)
    {
        if(entity != null)
        {
            this.id=entity.getId();
            this.direccion=entity.getDireccion();
            this.imagen=entity.getImagen();
            this.linkGoogleMaps=entity.getLinkGoogleMaps();
            this.nombre=entity.getNombre();            
        }
    }
     /*
    cambia los atributos a tipo entity
    */
     public LugarEntity toEntity( )
    {
       LugarEntity entity = new LugarEntity();
       entity.setDireccion(this.direccion);
       entity.setId(this.id);
       entity.setImagen(this.imagen);
       entity.setLinkGoogleMaps(this.linkGoogleMaps);
       entity.setNombre(this.nombre);
       return entity;
    }

    /*
    * devuelve el id
    */
    public Long getId() 
    {
        return id;
    }
    
    /*
    * cambia el id
    */
    public void setId(Long id)
    {
        this.id = id;
    }
    
    /*
    * devuelve el nombre
    */
    public String getNombre()
    {
        return nombre;
    }
    
    /*
    * cambia el nombre
    */
    public void setNombre(String n) {
        this.nombre = n;
    }
    
    /*
    * devuelve la dirrecion
    */
    public String getDireccion()
    {
        return direccion;
    }
    /*
    * cambia la direccion
    */
    public void setDireccion(String d)
    {
        this.direccion=d;
    }
    /*
    * devuelve el info del acceso
    */
    public String getLinkGoogleMaps()
    {
        return linkGoogleMaps;
    }
    /*
    * cambia la info
    */
    public void setLinkGoogleMaps(String i)
    {
      this.linkGoogleMaps=i;
    }
    /*
    * devuelve la image
    */
    public String getImagen()
    {
        return imagen;
    }
    /*
    cambia la imagen
    */
    public void setImagen(String i)
    {
        this.imagen=i;
    }    
}

