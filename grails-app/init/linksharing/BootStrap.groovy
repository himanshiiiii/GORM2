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

                Topic topic = new Topic(name: "cloud", createdBy: it, visibility: Visibility.PUBLIC)

                Topic topic1 = new Topic(name: "Java", createdBy: it, visibility: Visibility.PRIVATE)

                Topic topic2 = new Topic(name: "BootStrap", createdBy: it, visibility: Visibility.PUBLIC)

                Topic topic3 = new Topic(name: "compiler", createdBy: it, visibility: Visibility.PRIVATE)

                Topic topic4 = new Topic(name: "Datastructure", createdBy: it, visibility: Visibility.PUBLIC)


                if(topic.save())
                    it.addToTopics(topic)

                if(topic1.save())
                    it.addToTopics(topic1)

                if(topic2.save())
                    it.addToTopics(topic2)

                if(topic3.save())
                    it.addToTopics(topic3)

                if(topic4.save())
                    it.addToTopics(topic4)


                else {
                    log.error("Topic ${topic.errors.getFieldErrors()}")
                    log.error("Topic ${topic1.errors.getFieldErrors()}")
                    log.error("Topic ${topic2.errors.getFieldErrors()}")
                    log.error("Topic ${topic3.errors.getFieldErrors()}")
                    log.error("Topic ${topic4.errors.getFieldErrors()}")

                }
                it.save()
                log.info("Topics Saved Successfully")


            }
        }
    }

        def destroy = {
        }
    }