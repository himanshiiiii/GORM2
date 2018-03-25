package com.ttn.linksharing

class User {
    String email
    String userName
    String password
    String firstName
    String lastName
    byte photo
    boolean admin
    boolean active
    Date dateCreated
    Date lastUpdated

    String name


    static transients = ['name']
    String getName() {
        return "${firstName} ${lastName}"
    }


        static hasMany = [topics:Topic, subscriptions:Subscription,readingItems:ReadingItem, resources:Resource]


        static constraints = {
            email(unique: true,email: true,blank: false,nullable: false)
            password(blank: false,nullable: false,size: 5..15)
            firstName(blank: false,nullable: false)
            lastName(blank: false,nullable: false)
            photo(nullable:true, sqlType:'longBlob')
            admin(nullable:true)
        }
    }
