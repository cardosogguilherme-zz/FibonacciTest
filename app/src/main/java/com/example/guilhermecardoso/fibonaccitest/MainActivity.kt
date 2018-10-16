package com.example.guilhermecardoso.fibonaccitest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.guilhermecardoso.fibonaccitest.fibonacci.FibonacciFragment
import com.example.guilhermecardoso.fibonaccitest.fibonacci.FibonacciPresenter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter = FibonacciPresenter()
        val fragment = FibonacciFragment.newInstance(presenter)
        presenter.attach(fragment)
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment).commit()

    }
}
