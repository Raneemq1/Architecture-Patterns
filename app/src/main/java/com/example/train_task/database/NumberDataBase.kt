package com.example.train_task.database

import com.example.train_task.model.NumberModel

class NumberDataBase {

    /**
     * This method simulate retrieving the data from database
     */
    fun getNumbers():NumberModel{
        return NumberModel(2,4)
    }
}