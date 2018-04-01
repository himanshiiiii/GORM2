package com.ttn.linksharing

import co.ResourceSearchCO
import co.SearchCO
import org.hibernate.ObjectNotFoundException
import vo.RatingInfoVO

class ResourceController {

    def index() { }


    def delete(Integer id){

        Resource resource=Resource.load(id)
        println resource

    }
    def handleObjectNotFoundException(ObjectNotFoundException e) {

        render ("no object found ")
    }
    def search(){
        ResourceSearchCO resourceSearchCO=new ResourceSearchCO()
        if(resourceSearchCO.q)
            resourceSearchCO.visibility=Visibility.PUBLIC
    }
    def show(Integer id){
        Resource resource=Resource.get(id)
        SearchCO searchCO=new SearchCO(q:"sdcbdbdd")
        RatingInfoVO ratingInfoVO= resource.getRatingInfoVo(resource)
        println ("-----topost------- ${resource.topPost()}")
        println ("===unread=== ${session.user.getUnreadResource(searchCO)}")
        render(ratingInfoVO.averagescore)
        // println Topic.getTrendingTopics()
    }
    def handleNullPointerException(NullPointerException e) {

        render ("null found")
    }
    }

