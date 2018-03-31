package com.ttn.linksharing


class ApplicationInterceptor {


    ApplicationInterceptor(){
        matchAll()

    }

    boolean before() {
        log.info("ACTION AND CONTROLLER LOG: ${params.toString()}")
        true
    }

    boolean after() {
        log.info("ACTION AND CONTROLLER LOG: ${params.toString()}")
        true
    }


    void afterView() {
        // no-op
    }
}
