package app.filipebezerra.demo.android.movpaybank.data.mapper

import app.filipebezerra.demo.android.movpaybank.data.api.BankValueDto
import app.filipebezerra.demo.android.movpaybank.data.api.BankWidgetButtonActionContentDto
import app.filipebezerra.demo.android.movpaybank.data.api.BankWidgetButtonDto
import app.filipebezerra.demo.android.movpaybank.data.api.BankWidgetDto
import app.filipebezerra.demo.android.movpaybank.domain.model.*

class BankWidgetMapper : Mapper<BankWidgetDto, BankWidget> {

    override suspend fun map(from: BankWidgetDto) = BankWidget(
        identifier = from.identifier,
        content = BankWidgetContent(
            title = from.content.title,
            cardNumber = from.content.cardNumber,
            balance = from.content.balance.mapOrNul(),
            button = from.content.button.mapOrNull()
        )
    )

    private fun BankValueDto?.mapOrNul() = this?.let { fromBalanceDto ->
        BankValue(
            label = fromBalanceDto.label,
            value = fromBalanceDto.value
        )
    }

    private fun BankWidgetButtonDto?.mapOrNull() = this?.let { buttonDto ->
        BankWidgetButton(
            text = buttonDto.text,
            action = BankWidgetButtonAction(
                identifier = buttonDto.action.identifier,
                content = buttonDto.action.content.mapOrNull()
            )
        )
    }

    private fun BankWidgetButtonActionContentDto?.mapOrNull() = this?.let { buttonActionContentDto ->
        BankWidgetButtonActionContent(
            cardId = buttonActionContentDto.cardId,
            accountId = buttonActionContentDto.accountId
        )
    }
}