package com.ttn.linksharing

class UserController {

    def index() {
        render(session.user.userName)
    }

    def show(Integer id){
        if(Topic.findAllById(id).size()==0) {
            flash.error="No Topics Found"
            redirect(controller:"login",action:"index")
        }

        render("Topics Found")

    }
}
