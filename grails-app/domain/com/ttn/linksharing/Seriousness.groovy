package com.ttn.linksharing

enum Seriousness {
    SERIOUS,VERYSERIOUS,CASUAL


    static constraints = {
    }

    static Seriousness stringToEnum(String seriousness){
        if(seriousness==seriousness.toLowerCase())
            return Seriousness.valueOf(seriousness.toUpperCase())
        else
            return Seriousness.valueOf(seriousness)

    }
}
