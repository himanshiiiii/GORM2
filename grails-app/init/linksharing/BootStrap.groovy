package com.ttn.linksharing

import constant.DefaultPassword

//Add createUsers method to Bootstrap to create 1 admin and 1 normal user


class BootStrap {

    def init = { servletContext ->
        createUsers()
    }

    void createUsers() {
        if(User.count()==0) {

            //admin
            User admin = new User(email: "admin@gmail.com", password: DefaultPassword.PASSWORD, firstName: "admin", lastName: "portal", userName: "adminPortal", /*photo: 121,*/ admin: true, active: true)
            if(admin.save()){
                log.info("Admin Saved Successfully")
            }
            else {
                log.error("error: ${admin.errors.getAllErrors()}")
            }

            //normal
            User normal = new User(email: "himanshigupta238@gmail.com", password: DefaultPassword.PASSWORD, firstName: "Himanshi", lastName: "Gupta", userName: "HimanshiGupta", /*photo:122,*/ admin: false, active: true)
            if(normal.save()){
                log.info("Normal User Saved Successfully")
            }
            else {
                log.error("error: ${normal.errors.getFieldErrors()}")
            }

        }
    }

        def destroy = {
        }
    }