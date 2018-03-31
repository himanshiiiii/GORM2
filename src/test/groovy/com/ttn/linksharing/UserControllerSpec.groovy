package com.ttn.linksharing

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification


class UserControllerSpec extends Specification implements ControllerUnitTest<UserController>,DomainUnitTest<User> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
        true == false
    }

    void "when index is called it should display username"(){
        given:
        User user = new User(email: "himanshigupta238@gmail.com", userName: "HimanshiGupta", password: "mysql",
                firstName: "Himanshi", lastName: "Gupta", admin: false, active: true, photo: 101)

        user.save(flush: true)
        session["user"]=user
        when:
        controller.index()
        then:
        response.contentAsString=="HimanshiGupta"


    }
}