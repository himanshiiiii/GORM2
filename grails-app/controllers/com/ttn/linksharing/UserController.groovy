package com.ttn.linksharing

class UserController {

    def index() {
        render(session.user.userName)
    }

    def show(Integer id){
        if(!Topic.findByIdAndVisibility(id,Visibility.PUBLIC)) {
            flash.error="No Topics Found"
            redirect(controller:"login",action:"index")
        }

        render("sucess")


    }
}
