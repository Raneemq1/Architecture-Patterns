package com.example.train_task.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.train_task.R
import com.example.train_task.database.NumberDataBase

class MainActivity : AppCompatActivity(), NumberView {

    /**
     * Declare layout widgets
     */
    @BindView(R.id.num1)
    lateinit var num1_text: TextView

    @BindView(R.id.num2)
    lateinit var num2_text: TextView

    @BindView(R.id.plus_res)
    lateinit var plus_res: TextView

    @BindView(R.id.sub_res)
   lateinit var sub_res: TextView

    @BindView(R.id.mul_res)
     lateinit var mul_res: TextView

    @BindView(R.id.mul_btn)
    lateinit var mul_btn: Button

    @BindView(R.id.plus_btn)
     lateinit var plus_btn: Button

    @BindView(R.id.minus_btn)
     lateinit var minus_btn: Button

    /**
     * Initialize an instance to the database
     */
    private lateinit var number_db: NumberDataBase
    /**
     * Initialize an instance to the presenter
     */
    private lateinit var mul_presenter: NumberPresenter
    /**
     * Initialize an instance to the view model
     */
    private lateinit var viewModel:NumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * Using butterKnife to bind the view
         */
        ButterKnife.bind(this)



        number_db = NumberDataBase()
        mul_presenter = NumberPresenter(this)
        viewModel=NumberViewModel()
        viewModel = ViewModelProviders.of(this).get(NumberViewModel::class.java)

        /**
         * Display the numbers on text views
         */
        viewNumbers()

        /**
         * Display the subtraction result by observing the mutable data change
         */
        observeViewModel()



    }


    private fun viewNumbers() {

        num1_text.text = number_db.getNumbers().first.toString()
        num2_text.text = number_db.getNumbers().second.toString()
    }

    /**
     * Make the view model object observed any change in a mutable live data
     * Assign subtraction result with this observed data
     */
    private fun observeViewModel(){
        viewModel.res.observe(this,Observer<Int>{res->
          sub_res.text=res.toString()
        })
    }

    /**
     * Handle plus button action by using MVC arch type
     * Retrieve  numbers from database method
     * Prepare result by invoke add result method
     * Display the result on result text
     */
    @OnClick(R.id.plus_btn)
     fun resultMVC() {
        val num1 = number_db.getNumbers().first
        val num2 = number_db.getNumbers().second
        val result = addResult(num1, num2)

        plus_res.text = result.toString()


    }

    private fun addResult(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    /**
     * Handle mul button action by using MVP arch type
     * Invoke get mul result from presenter class
     */
    @OnClick(R.id.mul_btn)
     fun resultMVP() {
        mul_presenter.getMulResult()
    }

    /**
     * This method is override the interface method
     * Assign mul result with the method parameter that assigned from the presenter class
     */
    override fun getMulResult(res: Int) {
        mul_res.text = res.toString()
    }

    /**
     * Handle sub button action by using MVVM arch type
     * Invoke get result method from view model class
     */
    @OnClick(R.id.minus_btn)
     fun resultMVVM(){
        viewModel.getResult()
    }

}