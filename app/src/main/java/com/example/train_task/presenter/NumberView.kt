package com.example.train_task.presenter

interface NumberView {

    /**
     * This method will call by presenter when the result is ready to communicate with view to display the result on it
     */
    fun getMulResult(res: Int)
}