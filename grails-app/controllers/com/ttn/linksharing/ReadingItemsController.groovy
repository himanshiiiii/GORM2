package com.ttn.linksharing

class ReadingItemsController {

    def index() { }

    def changeIsRead(Long id,Boolean isRead){
        // ReadingItem readingItem= ReadingItem.findByIdAndUser(id,session.user)
        if(ReadingItem.executeUpdate("update readingItem set isRead=:isRead where id=:id",[isRead:isRead,id:id])==0){
            render("error :(")
        }
        else
            render("success :)")
    }
}
