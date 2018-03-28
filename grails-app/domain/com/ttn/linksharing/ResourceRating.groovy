package com.ttn.linksharing

class ResourceRating {
    User createdBy
    Resource resource
    Integer score
    Date dateCreated
    Date lastUpdated

    static belongsTo = [user: User, resource: Resource]

    static constraints = {
        score( validator: {
            return it >= 1 &&  it<= 5
        })
        user(nullable: false,blank: false,unique: 'resource')
        resource(nullable: false,blank:false)



    }
}
