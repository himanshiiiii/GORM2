package com.ttn.linksharing

class ResourceRating {
    User createdBy
    Resource resource
    int score
    Date dateCreated
    Date lastUpdated

    static belongsTo = [user: User, resource: Resource]

    static constraints = {
        createdBy(nullable:false)
        resource(nullable: false)
        score(nullable:false,size:1..5)


    }
}
