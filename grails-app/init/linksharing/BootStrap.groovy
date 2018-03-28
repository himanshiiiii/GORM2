package com.ttn.linksharing

import constant.DefaultPassword


class BootStrap {

    def init = { servletContext ->
        createUsers()
        createTopics()
    }

    void createUsers() {
        if(User.count()==0) {

            //admin
            User admin = new User(email: "admin@gmail.com", password: DefaultPassword.PASSWORD, firstName: "admin", lastName: "portal", userName: "adminPortal", /*photo: 121,*/ admin: true, active: true)
            if(admin.save()){
                log.info("Admin Saved Successfully")
            }
            else {
                log.error("error: ${admin.errors.getAllErrors()}")
            }

            //normal
            User normal = new User(email: "himanshigupta238@gmail.com", password: DefaultPassword.PASSWORD, firstName: "Himanshi", lastName: "Gupta", userName: "HimanshiGupta", /*photo:122,*/ admin: false, active: true)
            if(normal.save()){
                log.info("Normal User Saved Successfully")
            }
            else {
                log.error("error: ${normal.errors.getFieldErrors()}")
            }

        }
    }


    void createTopics() {
        List<User> userCount = User.getAll()
        userCount.each {

            if (Topic.findAllByCreatedBy(it).size()==0) {
                //User normal = User.findByUserName("HimanshiGupta")

                Topic topic = new Topic(name: "cloud", createdBy: it, visibility: Visibility.PUBLIC)
                it.addToTopics(topic)

                Topic topic1 = new Topic(name: "Java", createdBy: it, visibility: Visibility.PRIVATE)
                it.addToTopics(topic1)

                Topic topic2 = new Topic(name: "Bootstrap", createdBy: it, visibility: Visibility.PUBLIC)
                it.addToTopics(topic2)

                Topic topic3 = new Topic(name: "Compiler", createdBy: it, visibility: Visibility.PRIVATE)
                it.addToTopics(topic3)

                Topic topic4 = new Topic(name: "DataStructure", createdBy: it, visibility: Visibility.PUBLIC)
                it.addToTopics(topic4)

                topic.validate()
                log.error("Topic ${topic.errors.getFieldErrors()}")
                topic.save()
                topic1.validate()
                log.error("Topic ${topic1.errors.getFieldErrors()}")
                topic1.save()
                topic2.validate()
                log.error("Topic ${topic2.errors.getFieldErrors()}")
                topic2.save()
                topic3.validate()
                log.error("Topic ${topic3.errors.getFieldErrors()}")
                topic3.save()
                topic4.validate()
                log.error("Topic ${topic4.errors.getFieldErrors()}")
                topic4.save()

            }
        }
    }

        def destroy = {
        }
    }