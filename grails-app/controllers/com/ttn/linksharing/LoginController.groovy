package com.ttn.linksharing

import constant.DefaultPassword
import org.grails.buffer.StreamCharBuffer

class LoginController {
    def index() {


    }

    def logout() {
        session.invalidate()
        redirect(action: 'index')
    }

    def loginHandler(String userName, String password) {
        println(userName)
        User user = User.findByUserNameAndPassword(userName, password)
        if(user!=null) {

            if(user.active) {
                session.user=user
                forward(controller: 'user', action: 'index')

            }
            else {
                flash.error = "Your account is not active"

            }
        }
        else
        {
            flash.error="User not found"
        }
        render(view:'index')


    }


    def register(){

        //admin
        User admin = new User(firstName: params.firstName, lastName: params.lastName, email: params.email,
                userName: params.userName , password: params.password,confirmPassword: params.confirmPassword)
        if(admin.validate()){
            log.info("admin registered successfully! ${admin.save(flush:true, failOnError : true)}")
            render("Success")
        }
        else {
            flash.message = "flash message is set"
            def msg = new StreamCharBuffer(message("admin not save", admin))
            render(msg)
        }





        //normal
        User normal = new User(firstName: params.firstName, lastName: params.lastName, email: params.email,
                userName: params.userName , password: params.password,confirmPassword: params.confirmPassword)
        if(normal.validate()){
            log.info("normal user registered successfully! ${normal.save(flush:true, failOnError : true)}")
            render("Success")
        }
        else {
            flash.message = "flash message is set"
            def msg = new StreamCharBuffer(message("normal not save", normal))
            render(msg)
        }

        redirect(action: "index")
    }



}
