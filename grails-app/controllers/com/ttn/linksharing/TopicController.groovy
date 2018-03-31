package com.ttn.linksharing

class TopicController {

    def index() { }


    def show(){
        Topic topic=Topic.read()
    }

    def delete(Integer id){
        Topic topic=Topic.load(id)
    }
}
