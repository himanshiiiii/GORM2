package com.ttn.linksharing

class Topic {
    String name
    Date dateCreated
    Date lastUpdated
    Visibility visibility
    static belongsTo = [ createdBy : User]
    static hasMany = [subscriptions:Subscription, resources:Resource]
    static constraints = {
        name(blank: false, nullable: false, unique: 'createdBy')
        visibility(nullable: false)
    }

        static mapping = {
           sort("name":'asc')
        }


    def afterInsert() {
        log.info "----------Into After Insert------"
        Topic.withNewSession{
            Subscription subscription= new Subscription(topic: this,seriousness: Seriousness.VERYSERIOUS,user: this.createdBy)
            subscription.validate()
            log.error("Topic ${subscription.errors.getFieldErrors()}")

            subscription.save()
        }



    }


    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                '}'
    }
}
