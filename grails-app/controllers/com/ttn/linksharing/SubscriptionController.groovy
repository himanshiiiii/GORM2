package com.ttn.linksharing

class SubscriptionController {

    def index() { }


    def save(){

    }

    def delete(Integer id){
        println(id)
        Subscription subscription=Subscription.load(id)
        if(subscription!=null)
        {
            subscription.delete(flush:true)
            render("success")
        }
        else
            render("not found")

    }

    def update(){

    }
}
