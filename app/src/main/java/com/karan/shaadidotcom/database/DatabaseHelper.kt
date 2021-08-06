package com.karan.shaadidotcom.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.karan.shaadidotcom.model.Contact
import com.karan.shaadidotcom.model.Message
import java.io.IOException
import java.util.*

class DatabaseHelper private constructor(context: Context) :
    SQLiteOpenHelper(context, DB_NAME + DB_SUFFIX, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(MessageTable.CREATE)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        // leaving it blank for now
    }

    companion object {
        private const val TAG = "DatabasHelper"
        private const val DB_NAME = "fuelFriend"
        private const val DB_SUFFIX = ".db"
        private const val DB_VERSION = 1
        private var mInstance: DatabaseHelper? = null
        private var mMessageList: List<Message>? = null

        /**
         * Database access point
         * Singleton instance
         * @param context context of the activity
         * @return database instance
         */
        private fun getInstance(context: Context): DatabaseHelper? {
            if (mInstance == null) {
                mInstance = DatabaseHelper(context.applicationContext)
            }
            return mInstance
        }

        /**
         * public methods to get list of messages [Message] from database
         * @param context context in which this is running in
         * @param fromDatabase `true` if database refresh is required, else `false`
         * @return All messages stored in database
         */
        fun getMessages(context: Context, fromDatabase: Boolean): List<Message>? {
            if (mMessageList == null || fromDatabase) {
                mMessageList = loadMessages(context)
            }
            return mMessageList
        }

        /**
         * Loads messages from database
         * @param context context in which this is running in
         * @return message list if database is not empty, else null
         */
        private fun loadMessages(context: Context): List<Message>? {
            val data = getMessageCursor(context)
            // handle empty database case
            if (data != null && data.count > 0) {
                val tmpMessageList: MutableList<Message> = ArrayList<Message>(data.count)
                do {
                    val message: Message = readMessages(data)
                    tmpMessageList.add(message)
                } while (data.moveToNext())
                return tmpMessageList
            }
            return null
        }

        /**
         * Gets all messages wrapped in a [Cursor] positioned at it's first element
         * @param context The context this is running in
         * @return All categories stored in database
         */
        private fun getMessageCursor(context: Context): Cursor? {
            val database: SQLiteDatabase = getReadableDatabase(context)
            // Query the database
            val data: Cursor = database.query(
                MessageTable.NAME,
                MessageTable.PROJECTION, null, null,
                null, null, null
            )
            // handles empty cursor case
            if (data != null) {
                data.moveToFirst()
            }
            return data
        }

        /**
         * Gets a message from the given position of cursor provided
         * magic number based on table projection, see [MessageTable]
         * @param data The cursor containing the data
         * @return The found message
         */
        private fun readMessages(data: Cursor): Message {
            val name = data.getString(1) //name of the message sender
            val number = data.getString(2) // number of the message sender
            val timestamp = data.getString(3) // time at which message was sent
            val otpCode = data.getString(4) // OTP code, sent in message

            // creates contact for message
            val contact = Contact(name, number)
            return Message(contact, otpCode, timestamp)
        }

        /**
         * public method used to write message in database table
         * @param context context in which this is running in
         * @param message message to be stored in database
         */
        fun writeMessage(context: Context, message: Message) {
            val writableDatabase: SQLiteDatabase = getWritableDatabase(context)
            try {
                writableDatabase.beginTransaction()
                try {
                    fillMessage(writableDatabase, message)
                    writableDatabase.setTransactionSuccessful()
                } finally {
                    writableDatabase.endTransaction()
                }
            } catch (e: IOException) {
                Log.e(TAG, "FillDatabase", e)
            }
        }

        /**
         * fill the given message in database table
         * @param db instance of db
         * @param message message to be stored in database
         * @throws IOException in case of error
         */
        @Throws(IOException::class)
        private fun fillMessage(db: SQLiteDatabase, message: Message) {
            val values: ContentValues = createContentValues(message)
            db.insert(MessageTable.NAME, null, values)
        }

        /**
         * Creates the content values to fill a message in database
         * @param message message to be filled
         * @return ContentValues containing writable data
         */
        private fun createContentValues(message: Message): ContentValues {
            val values = ContentValues()
            values.clear()
            values.put(MessageTable.COLUMN_NAME, message.contact.fullName)
            values.put(MessageTable.COLUMN_NUMBER, message.contact.number)
            values.put(MessageTable.COLUMN_TIMESTAMP, message.timestamp)
            values.put(MessageTable.COLUMN_OTP, message.otpCode)
            return values
        }

        private fun getReadableDatabase(context: Context): SQLiteDatabase {
            return getInstance(context)?.readableDatabase!!
        }

        private fun getWritableDatabase(context: Context): SQLiteDatabase {
            return getInstance(context)?.writableDatabase!!
        }
    }
}