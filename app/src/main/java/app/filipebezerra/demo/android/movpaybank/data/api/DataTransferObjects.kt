package app.filipebezerra.demo.android.movpaybank.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BankStatementDto(
    @Json(name = "balance") val balance: BankValueDto,
    @Json(name = "transactions") val transactions: List<BankValueDto>
)

@JsonClass(generateAdapter = true)
data class BankCardDto(
    @Json(name = "cardNumber") val cardNumber: String,
    @Json(name = "cardName") val cardName: String,
    @Json(name = "expirationDate") val expirationDate: String,
    @Json(name = "availableLimit") val availableLimit: String,
    @Json(name = "totalLimit") val totalLimit: String
)

@JsonClass(generateAdapter = true)
data class BankWidgetsResponse(
    @Json(name = "widgets") val widgets: List<BankWidgetDto>
)

@JsonClass(generateAdapter = true)
data class BankWidgetDto(
    @Json(name = "identifier") val identifier: String,
    @Json(name = "content") val content: BankWidgetContentDto
)

@JsonClass(generateAdapter = true)
data class BankWidgetContentDto(
    @Json(name = "title") val title: String,
    @Json(name = "cardNumber") val cardNumber: String? = null,
    @Json(name = "balance") val balance: BankValueDto? = null,
    @Json(name = "button") val button: BankWidgetButtonDto? = null
)

@JsonClass(generateAdapter = true)
data class BankValueDto(
    @Json(name = "label") val label: String,
    @Json(name = "value") val value: String,
    @Json(name = "description") val description: String? = null
)

@JsonClass(generateAdapter = true)
data class BankWidgetButtonDto(
    @Json(name = "text") val text: String,
    @Json(name = "action") val action: BankWidgetButtonActionDto,
)

@JsonClass(generateAdapter = true)
data class BankWidgetButtonActionDto(
    @Json(name = "identifier") val identifier: String,
    @Json(name = "content") val content: BankWidgetButtonActionContentDto? = null,
)

@JsonClass(generateAdapter = true)
data class BankWidgetButtonActionContentDto(
    @Json(name = "cardId") val cardId: String? = null,
    @Json(name = "accountId") val accountId: String? = null,
)