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


    String confirmPassword
    String name
    List<Topic> topics

    static transients = ['name']
    static hasMany = [topics:Topic,subscriptions:Subscription,resources:Resource,readingItems:ReadingItem,resourceRating:ResourceRating]

    static constraints = {
        email(unique: true,email: true,blank: false,nullable: false)
        userName(unique: true,blank: false,nullable: false)
        password(blank: false,nullable: false,minSize: 5, validator: {password, obj ->
            def password2 = obj.confirmPassword
            password == password2 ? true : ['invalid.matchingPasswords']
        })
        firstName(blank: false,nullable: false)
        lastName(blank: false,nullable: false)
        photo(nullable:true,sqlType:'longBlob')
        admin(nullable:true)
        confirmPassword(nullable: true,blank: true)

    }


    static mapping = {
        sort("id":"desc")
        subscriptions lazy: false
    }



    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}