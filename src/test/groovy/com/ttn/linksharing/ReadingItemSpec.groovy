package com.ttn.linksharing

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ReadingItemSpec extends Specification implements DomainUnitTest<ReadingItem> {

    def setup() {
        mockDomain(User)
        mockDomain(Topic)
        mockDomain(Resource)
        mockDomain(LinkResource)
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
        true == false
    }

    def "Readingitem resource should be unique per user"(){
        setup:
        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123'
        User user = new User(email: email,userName:"himanshi123",password:password, firstName: "Himanshi", lastName: "Gupta",admin:false,active:true)
        Topic topic = new Topic(name:"sd",visibility: Visibility.PUBLIC,createdBy: user)
        Resource resource=new LinkResource(url: "www.google.com",description: "link1",user: user,topic: topic)


        when:
        ReadingItem readingItem=new ReadingItem(isRead: true,user:user,resource:resource)

        readingItem.validate()
        readingItem.save()
        then:
        ReadingItem.count==1

        when:

        ReadingItem readingItem1=new ReadingItem(isRead: true,user:user,resource:resource)
        resource.addToReadingItems(readingItem1)
        // user.addToReadingItems(readingItem1)
        readingItem1.validate()
        readingItem1.save()
        ReadingItem readingItem2=new ReadingItem(isRead: true,user:user,resource:resource)
        resource.addToReadingItems(readingItem2)
        // user.addToReadingItems(readingItem2)

        readingItem2.validate()
        readingItem2.save()

        then:
        readingItem2.errors.getFieldErrorCount('user')==1
        readingItem2.errors.hasErrors()==true

    }

    def "isRead should not be null"(){
        setup:
        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123'
        User user = new User(email: email,userName:"himanshi123",password:password, firstName: "Himanshi", lastName: "Gupta",admin:false,active:true)
        Topic topic = new Topic(name:"sd",visibility: Visibility.PUBLIC,createdBy: user)
        Resource resource=new LinkResource(url: "www.google.com",description: "link1",user: user,topic: topic)


        when:
        ReadingItem readingItem=new ReadingItem(isRead: null,user:user,resource:resource)

        readingItem.validate()
        readingItem.save()
        then:
        readingItem.errors.getFieldErrorCount('isRead')==1



    }
    def "user should not be null"() {
        setup:
        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123'
        User user = new User(email: email, userName: "himanshi123", password: password, firstName: "Himanshi", lastName: "Gupta", admin: false, active: true)
        Topic topic = new Topic(name: "sd", visibility: Visibility.PUBLIC, createdBy: user)
        Resource resource = new LinkResource(url: "www.google.com", description: "link1", user: user, topic: topic)


        when:
        ReadingItem readingItem = new ReadingItem(isRead: true, user: null, resource: resource)

        readingItem.validate()
        readingItem.save()
        then:
        readingItem.errors.getFieldErrorCount('user') == 1
    }




    def "resource should not be null"(){
        setup:
        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123'
        User user = new User(email: email,userName:"himanshi123",password:password, firstName: "Himanshi", lastName: "Gupta",admin:false,active:true)
        Topic topic = new Topic(name:"sd",visibility: Visibility.PUBLIC,createdBy: user)
        Resource resource=new LinkResource(url: "www.google.com",description: "link1",user: user,topic: topic)


        when:
        ReadingItem readingItem=new ReadingItem(isRead: true,user:user,resource:null)

        readingItem.validate()
        readingItem.save()
        then:
        readingItem.errors.getFieldErrorCount('resource')==1



    }
}
