package com.ttn.linksharing

class Subscription {
    Date dateCreated
    //Date lastUpdated
    Seriousness seriousness
    static belongsTo = [user: User, topics: Topic]


    static constraints = {
        seriousness(nullable:false)
        topics(nullable: false, unique:'user')
        user(nullable: false)

    }
}
