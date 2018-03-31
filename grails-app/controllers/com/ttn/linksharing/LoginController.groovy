package com.ttn.linksharing

class LoginController {

    def index() {

        if(session.user)
            forward(controller: 'login',action:'index')
        else
            render( 'failure')

    }

    def logout(){
        session.invalidate()
        redirect(action:'index')
    }

    def loginHandler(){


        redirect(action:'index')
    }


}
