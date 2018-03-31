package com.ttn.linksharing

import grails.test.mixin.TestFor
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification implements DomainUnitTest<User> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect: "fix me"
        false == false
    }

    def "Email address of user should be unique"() {
        setup:

        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123'
        User user = new User(email: email, userName: "himanshi123", password: password, firstName: "Himanshi", lastName: "Gupta", admin: false, active: true)

        when:
        user.save()
        then:
        user.count() == 1


        when:
        User user1 = new User(email: email, userName: "himanshi", password: password, firstName: "Happy", lastName: "Shah", admin: false, active: true)
        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('email') == 1
        user1.errors.allErrors.size() == 1


    }

    def "Email address of user should be in valid format"() {
        setup:

        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123'
        User user = new User(email: email, userName: "himanshi123", password: password, firstName: "Himanshi", lastName: "Gupta", admin: false, active: true)

        when:
        user.save()
        then:
        user.count() == 1

        when:
        User user1 = new User(email: "himanshigupta", userName: "himanshi", password: password, firstName: "Happy", lastName: "Shah", admin: false, active: true)

        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('email') == 1
        user1.errors.allErrors.size() == 1


    }

    def "Email address of user should not be blank"() {
        setup:

        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123'
        User user = new User(email: email, userName: "himanshi123", password: password, firstName: "Himanshi", lastName: "Gupta", admin: false, active: true)

        when:
        user.save()
        then:
        user.count() == 1

        when:
        User user1 = new User(email: "", userName: "himanshi", password: password, firstName: "Happy", lastName: "Shah", admin: false, active: true)

        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('email') == 1
        user1.errors.allErrors.size() == 1
    }

    def "Email address of user should not be null"() {
        setup:

        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123'
        User user = new User(email: email, userName: "himanshi123", password: password, firstName: "Himanshi", lastName: "Gupta", admin: false, active: true)

        when:
        user.save()
        then:
        user.count() == 1

        when:
        User user1 = new User(email: null, userName: "himanshi", password: password, firstName: "Happy", lastName: "Shah", admin: false, active: true)

        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('email') == 1
        user1.errors.allErrors.size() == 1
    }

    def "Passowrd of a user should be minimum of 5 characters"() {
        setup:

        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123'
        User user = new User(email: email, userName: "himanshi123", password: password, firstName: "Himanshi", lastName: "Gupta", admin: false, active: true)

        when:
        user.save()
        then:
        user.count() == 1

        when:
        User user1 = new User(email: "happy@gmail.com", userName: "himanshi", password: "ab12", firstName: "Happy", lastName: "Shah", admin: false, active: true)

        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('password') == 1
        user1.errors.allErrors.size() == 1
    }

    def "Password of a user should not be blank or null"() {
        setup:

        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123'
        User user = new User(email: email, userName: "himanshi123", password: password, firstName: "Himanshi", lastName: "Gupta", admin: false, active: true)

        when:
        user.save()
        then:
        user.count() == 1

        when:
        User user1 = new User(email: "happy@gmail.com", userName: "happy", password: "", firstName: "Happy", lastName: "Shah", admin: false, active: true)

        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('password') == 1
        user1.errors.allErrors.size() == 1

        when:
        User user2 = new User(email: "happy1@gmail.com", userName: "happy1", password: null, firstName: "Happy", lastName: "Shah", admin: false, active: true)

        user2.save()
        then:
        User.count() == 1
        user2.errors.getFieldErrorCount('password') == 1
        user2.errors.allErrors.size() == 1
    }

    def "Username of user should be unique"() {
        setup:

        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123'
        User user = new User(email: email, userName: "himanshi123", password: password, firstName: "Himanshi", lastName: "Gupta", admin: false, active: true)

        when:
        user.save()
        then:
        user.count() == 1


        when:
        User user1 = new User(email: "happy@gmail.com", userName: "himanshi123", password: password, firstName: "Happy", lastName: "Shah", admin: false, active: true)
        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('userName') == 1
        user1.errors.allErrors.size() == 1

    }

    def "Username of user should not be blank or null"() {
        setup:

        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123'
        User user = new User(email: email, userName: "himanshi123", password: password, firstName: "Himanshi", lastName: "Gupta", admin: false, active: true)

        when:
        user.save()
        then:
        user.count() == 1


        when:
        User user1 = new User(email: "happy@gmail.com", userName: "", password: password, firstName: "Happy", lastName: "Shah", admin: false, active: true)
        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('userName') == 1
        user1.errors.allErrors.size() == 1

        when:
        User user2 = new User(email: "happy@gmail.com", userName: null, password: password, firstName: "Happy", lastName: "Shah", admin: false, active: true)
        user2.save()
        then:
        User.count() == 1
        user2.errors.getFieldErrorCount('userName') == 1
        user2.errors.allErrors.size() == 1

    }

    def "FirstName of user should not be blank or null"() {
        setup:

        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123'
        User user = new User(email: email, userName: "himanshi123", password: password, firstName: "Himanshi", lastName: "Gupta", admin: false, active: true)

        when:
        user.save()
        then:
        user.count() == 1


        when:
        User user1 = new User(email: "happy@gmail.com", userName: "happy", password: password, firstName: "", lastName: "Shah", admin: false, active: true)
        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('firstName') == 1
        user1.errors.allErrors.size() == 1

        when:
        User user2 = new User(email: "happy1@gmail.com", userName: "happy1", password: password, firstName: null, lastName: "Shah", admin: false, active: true)
        user2.save()
        then:
        User.count() == 1
        user2.errors.getFieldErrorCount('firstName') == 1
        user2.errors.allErrors.size() == 1

    }


    def "LastName of user should not be blank or null"() {
        setup:

        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123'
        User user = new User(email: email, userName: "himanshi123", password: password, firstName: "Himanshi", lastName: "Gupta", admin: false, active: true)

        when:
        user.save()
        then:
        user.count() == 1


        when:
        User user1 = new User(email: "happy@gmail.com", userName: "happy", password: password, firstName: "Happy", lastName: "", admin: false, active: true)
        user1.save()
        then:
        User.count() == 1
        user1.errors.getFieldErrorCount('lastName') == 1
        user1.errors.allErrors.size() == 1

        when:
        User user2 = new User(email: "happy1@gmail.com", userName: "happy1", password: password, firstName: "Happy", lastName: null, admin: false, active: true)
        user2.save()
        then:
        User.count() == 1
        user2.errors.getFieldErrorCount('lastName') == 1
        user2.errors.allErrors.size() == 1

    }


    def "To check to String"() {

        setup:
        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123'
        User user = new User(email: email, userName: "himanshi123", password: password, firstName: "Himanshi", lastName: "Gupta", admin: false, active: true)

        when:
        user.save()

        then:
        user.toString() ==
                "User{userName='${user.userName}'}"


    }

    def " password and confirm passowrd should match"(){
        setup:
        String email = "himanshi.gupta@tothenew.com"
        String password = 'him123456'

        when:
        User user = new User(email: email,userName:"himanshi123",
                password:password,confirmPassword: password, firstName: "Himanshi",
                lastName: "Gupta",admin:false,active:true)
        user.save()
        then:

        User.count()==1

        when:
        User user1 = new User(email: email,userName:"himanshi123",
                password:password,confirmPassword: "123", firstName: "Himanshi",
                lastName: "Gupta",admin:false,active:true)
        user1.save()

        then:
        user1.errors.getFieldErrorCount('password')==1

    }


}