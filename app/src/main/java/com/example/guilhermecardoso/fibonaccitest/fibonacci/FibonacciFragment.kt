package com.example.guilhermecardoso.fibonaccitest.fibonacci

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.guilhermecardoso.fibonaccitest.R

class FibonacciFragment: Fragment(), FibonacciContract.View {

    private lateinit var buttonNext: Button
    private lateinit var buttonPrevious: Button
    private lateinit var textViewResult: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var layout: ConstraintLayout

    private lateinit var presenter: FibonacciContract.Presenter

    companion object {
        fun newInstance(presenter: FibonacciContract.Presenter): FibonacciFragment {
            val instance = FibonacciFragment()
            instance.presenter = presenter
            return instance
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_fibonacci, container, false)
        buttonNext = view.findViewById(R.id.button_next)
        buttonPrevious = view.findViewById(R.id.button_previous)
        textViewResult = view.findViewById(R.id.textiview_result)
        progressBar = view.findViewById(R.id.progressBar)
        layout = view.findViewById(R.id.fibonacci_layout)

        presenter.calculateNextNumber()
        buttonNext.setOnClickListener { presenter.calculateNextNumber() }
        buttonPrevious.setOnClickListener { presenter.calculatePreviousNumber() }

        return view
    }

    override fun showLoading() {
        layout.visibility = View.INVISIBLE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        layout.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun presentNextNumber(fibonacciHolder: FibonacciDataHolder) {
        textViewResult.text = "${fibonacciHolder.result} = ${fibonacciHolder.second} + ${fibonacciHolder.first}"
    }

    override fun presentPreviousNumber(fibonacciHolder: FibonacciDataHolder) {
        textViewResult.text = "${fibonacciHolder.result} = ${fibonacciHolder.second} + ${fibonacciHolder.first}"
    }

    override fun presentNoPrevious() {
        Toast.makeText(context, "No previous number", Toast.LENGTH_SHORT).show()
    }
}