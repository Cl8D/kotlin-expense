class ExpenseReport {
    val expenses: MutableList<Expense> = ArrayList()
    var total = 0
    var mealExpenses = 0

    fun calculateExpenses() {
        for (expense in expenses) {
            addTotal(expense)
        }
    }

    private fun addTotal(expense: Expense) {
        if (expense.isMeal()) {
            mealExpenses += expense.amount
        }
        total += expense.amount
    }

    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }
}
