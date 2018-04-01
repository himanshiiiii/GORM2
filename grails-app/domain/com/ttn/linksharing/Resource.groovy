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
        search { ResourceSearchCO co ->
            if (co.q) {
                eq('q', co.q)
            }
            if (co.max) {
                ge('max', co.max)
            }

            if (co.offset) {
                ge('offset', co.offset)
            }

            if (co.order) {
                ge('order', co.order)
            }
            if (co.sort) {
                ge('sort', co.sort)
            }
            if (co.topicId) {
                ge('topicId', co.topicId)
            }


        }
    }
}
