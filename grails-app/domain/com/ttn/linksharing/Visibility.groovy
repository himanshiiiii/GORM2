package com.ttn.linksharing

    enum Visibility {

        PUBLIC, PRIVATE


        static Visibility stringToEnum(String visibility){
            return Visibility.valueOf(visibility)

        }

    }