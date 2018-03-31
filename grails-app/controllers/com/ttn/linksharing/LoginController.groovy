package com.ttn.linksharing

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


}
