package com.ttn.linksharing

class Subscription {
    Date dateCreated
    Date lastUpdated
    Topic topic
    Seriousness seriousness
    static belongsTo = [user: User, topic: Topic]


    static constraints = {
        seriousness(nullable:false)
        topic(nullable: false, unique:'user')
        user(nullable: false)

    }
}
