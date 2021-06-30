package app.filipebezerra.demo.android.movpaybank.data.source.remote

class InvalidBankCardException(override val message: String) :
    IllegalArgumentException(message) {
}