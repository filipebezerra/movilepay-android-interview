package app.filipebezerra.demo.android.movpaybank.data.source.remote

class InvalidBankCardException(id: String) :
    IllegalArgumentException("Invalid bank card: $id") {
}