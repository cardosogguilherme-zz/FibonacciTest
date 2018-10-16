package com.example.guilhermecardoso.fibonaccitest.fibonacci

interface FibonacciContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun presentNextNumber(fibonacciHolder: FibonacciDataHolder)
        fun presentPreviousNumber(fibonacciHolder: FibonacciDataHolder)
        fun presentNoPrevious()
    }

    interface Presenter {
        fun calculateNextNumber()
        fun calculatePreviousNumber()
        fun attach(view: View)
        fun dettach()
    }

}