package com.ttn.linksharing
abstract class Resource {
    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastCreated

    static belongsTo = [user: User, topic: Topic]
    static hasMany = [resourceRating: ResourceRating, readingItems: ReadingItem]
    static constraints = {
        description(type: 'text')
    }
}
