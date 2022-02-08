package com.example.messanger.model

class Chat {

    var message :Message? = null
    var rooms :ArrayList<Room> = ArrayList<Room>()

    constructor(message: Message){
        this.message = message
    }

    constructor(rooms: ArrayList<Room>){
        this.rooms = rooms
    }

}