package com.bodan.maplebgm

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_memo")
class RoomMemo {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var no: Long? = null

    @ColumnInfo
    var filename: String = ""

    @ColumnInfo
    var name1: String = ""

    @ColumnInfo
    var name2: String = ""

    constructor(filename: String, name1: String, name2: String) {
        this.filename = filename
        this.name1 = name1
        this.name2 = name2
    }
}