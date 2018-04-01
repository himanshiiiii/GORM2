package com.ttn.linksharing

import constant.DefaultPassword
import org.grails.buffer.StreamCharBuffer

class LoginController {
    def index() {


    }


    def logout() {
        session.invalidate()
        redirect(action:'login/index')
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
                flash.error = "Your account is Not Active"

            }
        }
        else
        {
            flash.error="User Not Found"
        }
        render(view:'index')


    }

    def register(){
        User admin = new User(email: "admin@gmail.com", password: DefaultPassword.PASSWORD, firstName: "admin", lastName: "portal", userName: 'adminPortal', photo: 121, admin: true, active: true)
        if(admin.save()){
            flash.message="Admin Saved Successfully"
        }
        else {
            flash.error="error"
        }

        //normal
        User normal = new User(email: "himanshigupta238@gmail.com", password: DefaultPassword.PASSWORD, firstName: "Himanshi", lastName: "Gupta", userName: 'HimanshiGupta', photo: 122, admin: false, active: true)
        if(normal.save()){
            flash.message="Normal User Saved Successfully"

        }
        else {
            flash.error="error"

        }

        redirect(action: "index")
    }


}
