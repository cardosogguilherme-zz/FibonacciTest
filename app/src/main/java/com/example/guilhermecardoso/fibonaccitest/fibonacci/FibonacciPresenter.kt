package com.example.guilhermecardoso.fibonaccitest.fibonacci

class FibonacciPresenter: FibonacciContract.Presenter {
    private var view: FibonacciContract.View? = null

    private var firstNumber: Int = 1
    private var secondNumber: Int = 1
    private var result: Int = -1

    override fun calculateNextNumber() {
        result = firstNumber + secondNumber

        val fibonacciHolder = FibonacciDataHolder(firstNumber, secondNumber, result)
        view?.presentNextNumber(fibonacciHolder)

        firstNumber = secondNumber
        secondNumber = result
    }

    override fun calculatePreviousNumber() {
        if (secondNumber == firstNumber) {
            view?.presentNoPrevious()
            return
        }

        val newFirst = secondNumber - firstNumber
        result = secondNumber
        secondNumber = firstNumber
        firstNumber = newFirst

        val fibonacciHolder = FibonacciDataHolder(firstNumber, secondNumber, result)
        view?.presentNextNumber(fibonacciHolder)
    }

    override fun attach(view: FibonacciContract.View) {
        this.view = view
    }

    override fun dettach() {
        if (view != null) {
            view = null
        }
    }
}