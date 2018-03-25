package com.ttn.linksharing
abstract class Resource {
    String description
    User createdBy
    Topic topic
    Date dateCreated
    Date lastCreated

    static belongsTo = [user:User]
    static hasMany = [ratings:ResourceRating, readingItems:ReadingItem]

    static constraints = {
    }
}
