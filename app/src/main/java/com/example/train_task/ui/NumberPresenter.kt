package com.example.train_task.ui

import com.example.train_task.database.NumberDataBase
import com.example.train_task.model.NumberModel

class NumberPresenter(private val view: NumberView) {

    /**
     * This method invoke database to retrieve the data in a number model format
     */
    private fun getNumbers(): NumberModel {
        val db = NumberDataBase()
        return db.getNumbers()
    }

    /**
     * This method prepare the multiplication result from retrieved data and assign it to interface method
     */
     fun getMulResult() {
        val numberModel = getNumbers()
        val result = numberModel.first * numberModel.second
        view.getMulResult(result)

    }
}