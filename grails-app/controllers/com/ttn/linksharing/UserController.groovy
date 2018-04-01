package com.ttn.linksharing

import co.SearchCO

class UserController{

    def index(SearchCO searchCO) {

        render(session.user.userName)

        render session.user.getUnreadResource(searchCO)
    }

    def show(Integer id){

        Topic topic=Topic.get(id)
        if(topic.visibility==Visibility.PUBLIC) {
            render("success")
        }
        else{
            if(Subscription.findByTopicAndUser(topic,session.user))
                render("Subscription Exists")
            else
            {
                flash.error="Subscription does not exists"
                redirect(action:"login/index")
            }
        }
    }
}
