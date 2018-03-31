package com.ttn.linksharing

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

    }

