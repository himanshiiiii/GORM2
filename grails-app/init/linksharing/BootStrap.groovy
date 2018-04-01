package com.ttn.linksharing

import co.ResourceSearchCO
import constant.DefaultPassword


class BootStrap {

    def init = { servletContext ->
        createUsers()
        createTopics()
        createResource()
        subscribeTopicsNotCreatedByUser()
        createReadingItems()
        createResourceRating()
        question27()
        q1()

        //        FIX method arguments here
//        createReadingItemIfItDoesNotExistsInUsersReadingItem()


        ResourceSearchCO resourceSearchCO = new ResourceSearchCO(visibility: Visibility.PUBLIC)
        log.info("-----------------------------------------")
//       def str= Resource.search(resourceSearchCO).list()
//        println(str)
        Resource resource = Resource.get(5)
        println resource.totalVotes(resource)
        println resource.avgScore(resource)
        println resource.totalScore(resource)

        List topics = Topic.getTrendingTopics()
        topics.each {
            println it.id
            println it.visibility
            println it.name
            println it.createdBy
            println it.count
        }

    }

    void createUsers() {
        if (User.count() == 0) {

            //admin
            User admin = new User(email: "admin@gmail.com", password: DefaultPassword.PASSWORD, firstName: "admin", lastName: "portal", userName: "adminPortal", /*photo: 121,*/ admin: true, active: true)
            if (admin.save()) {
                log.info("Admin Saved Successfully")
            } else {
                log.error("error: ${admin.errors.getAllErrors()}")
            }

            //normal
            User normal = new User(email: "himanshigupta238@gmail.com", password: DefaultPassword.PASSWORD, firstName: "Himanshi", lastName: "Gupta", userName: "HimanshiGupta", /*photo:122,*/ admin: false, active: true)
            if (normal.save()) {
                log.info("Normal User Saved Successfully")
            } else {
                log.error("error: ${normal.errors.getFieldErrors()}")
            }

        }
    }


    void createTopics() {
        List<User> userCount = User.getAll()
        userCount.each {

            if (Topic.findAllByCreatedBy(it).size() == 0) {

                Topic topic = new Topic(name: "cloud", createdBy: it, visibility: Visibility.PUBLIC)

                Topic topic1 = new Topic(name: "Java", createdBy: it, visibility: Visibility.PRIVATE)

                Topic topic2 = new Topic(name: "BootStrap", createdBy: it, visibility: Visibility.PUBLIC)

                Topic topic3 = new Topic(name: "compiler", createdBy: it, visibility: Visibility.PRIVATE)

                Topic topic4 = new Topic(name: "Datastructure", createdBy: it, visibility: Visibility.PUBLIC)


                if (topic.save())
                    it.addToTopics(topic)

                if (topic1.save())
                    it.addToTopics(topic1)

                if (topic2.save())
                    it.addToTopics(topic2)

                if (topic3.save())
                    it.addToTopics(topic3)

                if (topic4.save())
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


    void createResource() {

        if (Resource.count() == 0) {

            List<Topic> topics = Topic.getAll()

            topics.each {
                Resource resource = new LinkResource(url: "https://en.wikipedia.org/wiki/Big_data", description: "${it.name} url", topic: it, user: it.createdBy)
                Resource resource1 = new LinkResource(url: "https://www.sas.com/en_in/insights/big-data/what-is-big-data.html", description: "${it.name} bigdata", topic: it, user: it.createdBy)
                Resource resource2 = new DocumentResource(filePath: "abcd", description: "${it.name} hello bigdata", user: it.createdBy, topic: it)
                Resource resource3 = new DocumentResource(filePath: "efgh", user: it.createdBy, description: "${it.name} hello sas", topic: it)

                if (resource.save()) {
                    it.addToResources(resource)
                    it.createdBy.addToResources(resource)
                } else {
                    log.error("Resource Error: ${resource.errors.allErrors}")
                }
                if (resource1.save()) {
                    it.addToResources(resource1)
                    it.createdBy.addToResources(resource1)
                } else {
                    log.error("Resource Error: ${resource1.errors.allErrors}")
                }
                if (resource2.save()) {
                    it.addToResources(resource2)
                    it.createdBy.addToResources(resource2)

                } else {
                    log.error("Resource Error: ${resource2.errors.allErrors}")

                }
                if (resource3.save()) {
                    it.addToResources(resource3)
                    it.createdBy.addToResources(resource3)

                } else {
                    log.error("Resource Error: ${resource3.errors.allErrors}")
                }

                it.createdBy.save()
                it.save()
            }

        }
    }


        void subscribeTopicsNotCreatedByUser() {

            List<User> userList = User.getAll()

            userList.each {
                User user ->
                    List<Topic> topics = Topic.findAllByCreatedByNotEqual(user)

                    topics.each {
                        if (Subscription.findAllByTopicAndUser(it, user).size() == 0) {
                            Subscription subscription = new Subscription(seriousness: Seriousness.CASUAL, user: user, topic: it)
                            if (subscription.save()) {
                                it.addToSubscriptions(subscription)
                                user.addToSubscriptions(subscription)
                            } else {
                                log.error("Error:${subscription.errors.getAllErrors()}")
                            }
                        }
                    }


            }

        }
        void createReadingItems() {
            List<User> users = User.getAll()
            users.each {
                User user ->
                    user.subscriptions.each {

                        it.topic.resources.each {

                            if (it.user != user && ReadingItem.findAllByResourceAndUser(it, user).size() == 0) {
                                ReadingItem readingItem = new ReadingItem(user: user, isRead: true, resources: it)
                                if (readingItem.save()) {
                                    user.addToReadingItems(readingItem)
                                    user.save()
                                } else {
                                    log.error("Error:${readingItem.errors.getAllErrors()}")
                                }
                            }
                        }
                    }
            }
        }

//question 24
    void createReadingItemIfItDoesNotExistsInUsersReadingItem(User user,Topic topic)
    {
        topic.resources.each {
            ReadingItem readingItem=new ReadingItem(user: user,resource:it,isRead: false)
            if(readingItem.save()){
                it.addToReadingItems(readingItem)
                it.save()
                user.addToReadingItems(readingItem)
                user.save()
            }
            else{
                log.error("Error: ${readingItem.errors.getAllErrors()}")
            }
        }
    }

//question 26
    void createResourceRating(){
        List<User> userList=User.getAll()
        userList.each {
            User user->
                user.readingItems.each {
                    if(!it.isRead && ResourceRating.findAllByUser(user).size()==0){
                        ResourceRating resourceRating=new ResourceRating(user: user, resource: it.resource,score:4)
                        resourceRating.validate()
                        if(resourceRating.save()){
                            log.info("Saved Successfully")
                            user.addToResourceRating(resourceRating)
                            user.save()
                        }
                        else {
                            log.error("${resourceRating.errors.getAllErrors()}")
                        }
                    }
                }

        }

    }



    void question27(){
        List<ResourceRating> resourceRatingList=ResourceRating.getAll()
        resourceRatingList.each {
            ResourceRating resourceRating->
                if(ReadingItem.findAllByUserAndResource(resourceRating.user,resourceRating.resource).size()==0) {
                    ReadingItem readingItem = new ReadingItem(user: resourceRating.user, resource: resourceRating.resource, isRead: false)
                    if (readingItem.save()){
                        log.info("Saved Successfully")
                        resourceRating.resource.addToReadingItems(readingItem)
                        resourceRating.user.addToReadingItems(readingItem)
                        resourceRating.resource.save()
                        resourceRating.user.save()
                    }
                    else {
                        log.error("Error:- ${readingItem.errors.getAllErrors()}")
                    }
                }
        }
    }


    void q1(){

        println User.findAll()
        println Topic.findAll()
    }


    def destroy = {
        }
    }