package app.filipebezerra.demo.android.movpaybank.data.source.remote

class InvalidBankStatementException(id: String) :
    IllegalArgumentException("Invalid bank statement: $id") {
}