package com.ttn.linksharing

class ReadingItem {
    User createdBy
    boolean isRead
    Resource resource
    Date dateCreated
    Date lastUpdated

    static belongsTo = [user:User,resource:Resource]

    static constraints = {
        createdBy(nullable: false)
        resource(blank: false, nullable: false, unique: 'user')
        isRead(nullable:false)


    }
}
