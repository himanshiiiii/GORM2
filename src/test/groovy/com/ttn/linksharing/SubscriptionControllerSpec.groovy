package com.ttn.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(SubscriptionController)
class SubscriptionControllerSpec extends Specification {

    def setup() {
        mockDomain(User)
        mockDomain(Topic)

    }


    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
        true == false
    }

    def "data should be saved on save action"(){
        given:
        User user = new User(email: "himanshigupta238@gmail.com", userName: "HimanshiGupta", password: "mysql",
                firstName: "Himanshi", lastName: "Gupta", admin: false, active: true, photo: 101)
        Topic topic=new Topic(createdBy: user, name: "topic",visibility: Visibility.PUBLIC)

        session.user=user
        topic.save(flush:true ,failOnError:true)
        /*user.addToTopics(topic)
        user.save()*/

        when:
        controller.save(topic.id)

        then:
        response.contentAsString=="error"


    }
}