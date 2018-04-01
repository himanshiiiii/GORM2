package com.ttn.linksharing

import vo.TopicVO

class Topic {
    String name
    Date dateCreated
    Date lastUpdated
    Visibility visibility
    static belongsTo = [createdBy: User]
    static hasMany = [subscriptions: Subscription, resources: Resource]
    static constraints = {
        name(blank: false, nullable: false, unique: 'createdBy')
        visibility(nullable: false)
    }

    static mapping = {
        sort("name": "asc")
        subscriptions lazy: false
    }


    def afterInsert() {
        log.info "----------Into After Insert------"
        Topic.withNewSession {
            Subscription subscription = new Subscription(topic: this, seriousness: Seriousness.VERYSERIOUS, user: this.createdBy)
            subscription.validate()
            log.error("Topic ${subscription.errors.getFieldErrors()}")

            subscription.save()
        }


    }

    static List<TopicVO> getTrendingTopics(){
        List topicList = Resource.createCriteria().list {
            projections {
                createAlias('topic', 't')
                groupProperty('t.id')
                property('t.name')
                property('t.visibility')
                count('t.id', 'topicCount')
                property('t.createdBy')
            }
            eq('t.visibility',Visibility.PUBLIC)
            order('topicCount', 'desc')
            order('t.name', 'asc')
            maxResults(5)
        }

        List topicVOList = []
        topicList.each {

            topicVOList.add(new TopicVO(id: it[0], name: it[1], visibility: it[2], count: it[3], createdBy: it[4]))


        }
        return topicVOList



    }


    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                '}'
    }
}
