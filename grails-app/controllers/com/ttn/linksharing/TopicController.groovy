package com.ttn.linksharing

class TopicController {

    def index() {}


    def show() {
        Topic topic = Topic.read()
    }

    def delete(Integer id) {
        Topic topic = Topic.load(id)
    }


    def save(Topic topic) {
        if (topic.save()) {
            render("saved Successfully")
        } else {
            render("error")
        }


    }
}
