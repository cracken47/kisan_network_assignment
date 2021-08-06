package com.karan.shaadidotcom.model


class Message(// contact associated with message
    val contact: Contact, // otp code that has been sent on number
    val otpCode: String, // timestamp at which message has been sent
    val timestamp: String
)