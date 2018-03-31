package com.ttn.linksharing

class LoginController {

    def index() { }

    def logout(){
        redirect(action:'index')
    }

    def loginHandler(){
        redirect(action:'index')
    }


}
