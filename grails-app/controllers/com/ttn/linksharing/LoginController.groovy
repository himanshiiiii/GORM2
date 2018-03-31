package com.ttn.linksharing

class LoginController {
    def index() {

        if (session.user)
        {
            forward(controller: 'user', action: 'index')
        }
        else {
            if(flash.error)
                render(view: "index")
            else
                render("failure")
        }
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
            }
            else {
                flash.error = "Your account is not active"

            }
        }
        redirect(action: 'index')
    }


}
