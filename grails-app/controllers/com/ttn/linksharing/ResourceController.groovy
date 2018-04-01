package com.ttn.linksharing

import co.ResourceSearchCO
import org.hibernate.ObjectNotFoundException

class ResourceController {

    def index() { }

    def delete(Integer id){
        Resource resource=Resource.load(id)
        println resource
    }


    def handleObjectNotFoundException(ObjectNotFoundException e) {

        render ("no object found")
    }


    def search(){
        ResourceSearchCO resourceSearchCO=new ResourceSearchCO()
        if(resourceSearchCO.q)
            resourceSearchCO.visibility=Visibility.PUBLIC
    }

    }

