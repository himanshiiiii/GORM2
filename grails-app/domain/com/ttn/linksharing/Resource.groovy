package com.ttn.linksharing

import co.ResourceSearchCO

abstract class Resource {
    String description
    Topic topic
    Date dateCreated
    Date lastUpdated

    static belongsTo = [user: User, topic: Topic]
    static hasMany = [resourceRating: ResourceRating, readingItems: ReadingItem]
    static constraints = {
        description(type: 'text')
    }


    static namedQueries = {
        search {
            ResourceSearchCO resourceSearchCO ->
                if(resourceSearchCO.topicId)
                    eq('topic.id', resourceSearchCO.topicId)
                if(resourceSearchCO.visibility)
                    eq('topic.visibility',resourceSearchCO.visibility)

        }
    }
}
