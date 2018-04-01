package com.ttn.linksharing

import co.ResourceSearchCO

class TopicController {

    def index() {}


    def show(ResourceSearchCO resourceSearchCO, Long id){

        User user=User.read(session.user.id)
        //println user.topics
        render(user.topics)
    }

    def delete(Integer id){
        println id
        Topic topic=Topic.load(id)
        println(topic)
        if(topic.delete()) {
            flash.message="sucess"

        }
        else {
            flash.error="error"

        }
    }


    def save(Topic topic,String seriousness){
        if(topic.save()){
            render("saved Successfully")
        }
        else{
            flash.error="Error"
            render("Error")
        }


    }
}
