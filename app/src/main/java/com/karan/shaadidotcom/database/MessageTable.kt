package com.karan.shaadidotcom.database

/**
 * Interface used to Create and Populate Message in database
 */
interface MessageTable {
    companion object {
        const val NAME = "message"
        const val COLUMN_ID = "_id"
        const val COLUMN_NAME = "contact_name"
        const val COLUMN_NUMBER = "contact_number"
        const val COLUMN_TIMESTAMP = "timestamp"
        const val COLUMN_OTP = "otp"

        val PROJECTION: Array<String> = arrayOf(
            COLUMN_ID, COLUMN_NAME, COLUMN_NUMBER,
            COLUMN_TIMESTAMP, COLUMN_OTP
        )
        const val CREATE = ("CREATE TABLE " + NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + COLUMN_NAME + " TEXT NOT NULL, "
                + COLUMN_NUMBER + " TEXT NOT NULL, "
                + COLUMN_TIMESTAMP + " TEXT NOT NULL, "
                + COLUMN_OTP + " TEXT NOT NULL);")
    }
}