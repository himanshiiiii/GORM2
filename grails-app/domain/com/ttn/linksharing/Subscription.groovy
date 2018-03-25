package com.ttn.linksharing

class Subscription {
    Date dateCreated
    Date lastUpdated
    Seriousness seriousness
    static belongsTo = [user: User, topic: Topic]


    static constraints = {
        user(blank: false, nullable: false, unique: 'user')
        topic(nullable: false, blank: false, unique: 'user')
        seriousness(nullable: false, blank: false)

    }
}
