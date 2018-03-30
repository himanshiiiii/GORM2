package com.ttn.linksharing

class ReadingItem {
    User user
    boolean isRead
    Resource resource
    Date dateCreated
    Date lastUpdated

    static belongsTo = [user:User,resource:Resource]

    static constraints = {
       user(nullable: false)
        resource(blank: false, nullable: false, unique: 'user')
        isRead(nullable:false)


    }
}
