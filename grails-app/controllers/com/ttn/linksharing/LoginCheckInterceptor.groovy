package com.ttn.linksharing


class LoginCheckInterceptor {

    LoginCheckInterceptor(){
        matchAll().excludes(controller: 'login', action: 'loginHandler')
    }

    boolean before() {
        if (!session.user) {
            flash.error= "NO ACTIVE SESSION"
            redirect(view:"login/index")
        }

        true
    }

    boolean after() { true }
    void afterView() {
        // no-op
    }
}
