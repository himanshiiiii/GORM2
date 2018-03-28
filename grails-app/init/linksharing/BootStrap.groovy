package com.ttn.linksharing

//Add createUsers method to Bootstrap to create 1 admin and 1 normal user


class BootStrap {

    def init = { servletContext ->
        createUsers()
    }
    void createUsers(){

        //admin
        User admin=new User(email: "admin@gmail.com",password: "admin@123",firstName: "admin",lastName: "Linksharing",userName:'adminLinksharing' , photo: 121,admin:true,active:true)
        admin.validate()
        admin.save(failOnError:true)


        //normal
        User normal=new User(email: "himanshigupta238@gmail.com",password: "admin@123",firstName: "Himanshi",lastName: "Gupta",userName:'HimanshiGupta',photo: 122,admin:false,active:true)
        normal.validate()
        normal.save(failOnError:true)






    }
    def destroy = {
    }
}