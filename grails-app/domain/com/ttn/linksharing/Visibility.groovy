package com.ttn.linksharing

    enum Visibility {

        PUBLIC("public"), PRIVATE("private")

        private String name


        @Override
        public String toString() {
            return "Visibility{" +
                    "name='" + name + '\'' +
                    '}';
        }


        static Visibility valueOfName(name) {
            values().find { it.name == name }
        }

        //Visibility.valueOfName("public")
    }