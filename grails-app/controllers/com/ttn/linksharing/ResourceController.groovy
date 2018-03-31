package com.ttn.linksharing

class ResourceController {

    def index() { }

    def delete(Integer id){
        Resource resource=Resource.load(id)
    }
}
