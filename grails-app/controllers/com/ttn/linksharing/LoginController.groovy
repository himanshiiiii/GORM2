package com.ttn.linksharing

class LoginController {

    def index() {

        if(session.user)
            forward(controller: 'login',action:'index')
        else
            render( 'failure')

    }

    def logout(){
        redirect(action:'/')
    }

    def loginHandler(){


        redirect(action:'index')
    }


}
