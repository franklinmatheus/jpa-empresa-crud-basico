/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imd.entity;

import java.io.Serializable;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author franklin
 */
@FacesConverter(value = "generic")
public class GenericConverter implements Serializable, Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            return this.getAttributesFrom(component).get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && !value.equals("")) {

            SampleEntity entity = (SampleEntity) value;

            this.addAttribute(component, entity);

            Long codigo = entity.getId();
            if (codigo != null) {
                return String.valueOf(codigo);
            }
        }

        return (String) value;
    }
    
    protected void addAttribute(UIComponent component, SampleEntity o) {
        String key = o.getId().toString();
        this.getAttributesFrom(component).put(key, o);
    }

    protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }
}
