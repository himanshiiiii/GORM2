package com.ttn.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TopicController)
class TopicControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }

    def "topic should be saved on save action"() {
        given:
        User user = new User(email: "himanshigupta238@gmail.com", userName: "Himanshi", password: "mysql",
                firstName: "Himanshi", lastName: "Gupta", admin: false, active: true, photo: 101)

        session.user=user
        Topic topic=new Topic(name: "topic20",visibility:Visibility.PUBLIC,createdBy: session.user)
        when:
        controller.save(topic, "Casual")

        then:
        println(topic.createdBy)
        response.contentAsString == "saved Successfully"


    }



    def "Delete topic"(){
        given:
        User user = new User(email: "himanshigupta238@gmail.com", userName: "HimanshiGupta", password: "mysql",
                firstName: "Himanshi", lastName: "Gupta", admin: false, active: true, photo: 101)
        session.user=user
        Topic topic=new Topic(name: "topic20",visibility:Visibility.PUBLIC,createdBy: session.user)
        topic.save(flush:true)
        user.addToTopics(topic)
        user.save()
        println(topic.id)
        when:
        controller.delete(topic.id)
        then:
        response.contentAsString=="sucess"

    }

}
