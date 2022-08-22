package com.example.train_task.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.train_task.database.NumberDataBase
import com.example.train_task.model.NumberModel

class NumberViewModel: ViewModel() {

    /**
     * Declare mutable live data variable to assign the result to it
     */
    var res=MutableLiveData<Int>()

    /**
     * This method invoke database to retrieve the data in a number model format
     */
    private fun getNumbers():NumberModel{
        val db=NumberDataBase()
        return db.getNumbers()
    }

    /**
     * This method prepare the multiplication result from retrieved data and assign it to mutable variable
     */
     fun getResult(){
         val numberModel=getNumbers()
         val result=numberModel.first-numberModel.second
         res.value=result
     }


}