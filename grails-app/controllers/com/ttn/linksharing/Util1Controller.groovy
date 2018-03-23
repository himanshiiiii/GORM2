package com.ttn.linksharing

class Util1Controller {

    def index() {
        log.info 'info'
        log.error 'error'

        log.debug 'Params Example [{}]', params
        [param: params]

        render "hello"
    }
}
