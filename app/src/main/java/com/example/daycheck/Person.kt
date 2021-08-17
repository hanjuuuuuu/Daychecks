package com.example.daycheck

//@Entity
data class Person(
    val mood: String,
    val symptom: String,
    val excerciseTime: String,
    val isDrinked: String,
    val isSmoking: String,
    val sleepTime: String,
    val year: Int,
    val month: Int,
    val day: Int
    ){
    //@PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
