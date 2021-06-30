package app.filipebezerra.demo.android.movpaybank.data.mapper

import app.filipebezerra.demo.android.movpaybank.data.api.BankCardDto
import app.filipebezerra.demo.android.movpaybank.domain.model.BankCard

class BankCardMapper : Mapper<BankCardDto, BankCard> {

    override suspend fun map(from: BankCardDto) = BankCard(
        cardNumber = from.cardNumber,
        cardName = from.cardName,
        expirationDate = from.expirationDate,
        availableLimit = from.availableLimit,
        totalLimit = from.totalLimit
    )
}