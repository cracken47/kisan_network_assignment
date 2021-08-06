package com.karan.shaadidotcom.networking

object NetworkHelper {

     const val BASE_URL = "https://api.twilio.com/2010-04-01/Accounts/"

    fun getUrl(accountId: String): String {
        return "$BASE_URL$accountId/SMS/Messages"
    }

}