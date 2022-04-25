package com.example.qrscsnner.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.qrscsnner.data.room.entity.ScannerEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class ScannerEntity(
    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0,
    @ColumnInfo(name = "result")
    val result: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "time")
    val time: String
){
    companion object{
        const val TABLE_NAME = "scanners"
    }
}
