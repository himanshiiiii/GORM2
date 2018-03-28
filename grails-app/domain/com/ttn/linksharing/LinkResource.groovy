package com.ttn.linksharing

class LinkResource extends Resource{

    String url
    Date dateCreated
    Date lastUpdated


    static constraints = {
        url(url: true,nullable:false,blank: false)
    }
}
