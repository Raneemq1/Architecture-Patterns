package com.example.train_task.model

/**
 * Define data class that contains a constructor with default values
 */
data class NumberModel(val first: Int, val second: Int) {
    constructor() : this(0, 0)
}