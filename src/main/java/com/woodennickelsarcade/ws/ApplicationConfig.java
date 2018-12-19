/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.woodennickelsarcade.ws;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Rhett Edwards
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.woodennickelsarcade.ws.GameWS.class);
        resources.add(com.woodennickelsarcade.ws.PayWS.class);
        resources.add(com.woodennickelsarcade.ws.ReviewWS.class);
    }
    
}
