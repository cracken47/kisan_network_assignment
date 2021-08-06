package com.karan.shaadidotcom.Database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/karan/shaadidotcom/Database/DatabaseHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "sqLiteDatabase", "i", "", "i1", "Companion", "app_debug"})
public final class DatabaseHelper extends android.database.sqlite.SQLiteOpenHelper {
    private static final java.lang.String TAG = "DatabasHelper";
    private static final java.lang.String DB_NAME = "fuelFriend";
    private static final java.lang.String DB_SUFFIX = ".db";
    private static final int DB_VERSION = 1;
    private static com.karan.shaadidotcom.Database.DatabaseHelper mInstance;
    private static java.util.List<com.karan.shaadidotcom.model.Message> mMessageList;
    @org.jetbrains.annotations.NotNull()
    public static final com.karan.shaadidotcom.Database.DatabaseHelper.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override()
    public void onUpgrade(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    
    private DatabaseHelper(android.content.Context context) {
        super(null, null, null, 0);
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0019H\u0002J\u0016\u0010\"\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/karan/shaadidotcom/Database/DatabaseHelper$Companion;", "", "()V", "DB_NAME", "", "DB_SUFFIX", "DB_VERSION", "", "TAG", "mInstance", "Lcom/karan/shaadidotcom/Database/DatabaseHelper;", "mMessageList", "", "Lcom/karan/shaadidotcom/model/Message;", "createContentValues", "Landroid/content/ContentValues;", "message", "fillMessage", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "getInstance", "context", "Landroid/content/Context;", "getMessageCursor", "Landroid/database/Cursor;", "getMessages", "fromDatabase", "", "getReadableDatabase", "getWritableDatabase", "loadMessages", "readMessages", "data", "writeMessage", "app_debug"})
    public static final class Companion {
        
        /**
         * Database access point
         * Singleton instance
         * @param context context of the activity
         * @return database instance
         */
        private final com.karan.shaadidotcom.Database.DatabaseHelper getInstance(android.content.Context context) {
            return null;
        }
        
        /**
         * public methods to get list of messages [Message] from database
         * @param context context in which this is running in
         * @param fromDatabase `true` if database refresh is required, else `false`
         * @return All messages stored in database
         */
        @org.jetbrains.annotations.Nullable()
        public final java.util.List<com.karan.shaadidotcom.model.Message> getMessages(@org.jetbrains.annotations.NotNull()
        android.content.Context context, boolean fromDatabase) {
            return null;
        }
        
        /**
         * Loads messages from database
         * @param context context in which this is running in
         * @return message list if database is not empty, else null
         */
        private final java.util.List<com.karan.shaadidotcom.model.Message> loadMessages(android.content.Context context) {
            return null;
        }
        
        /**
         * Gets all messages wrapped in a [Cursor] positioned at it's first element
         * @param context The context this is running in
         * @return All categories stored in database
         */
        private final android.database.Cursor getMessageCursor(android.content.Context context) {
            return null;
        }
        
        /**
         * Gets a message from the given position of cursor provided
         * magic number based on table projection, see [MessageTable]
         * @param data The cursor containing the data
         * @return The found message
         */
        private final com.karan.shaadidotcom.model.Message readMessages(android.database.Cursor data) {
            return null;
        }
        
        /**
         * public method used to write message in database table
         * @param context context in which this is running in
         * @param message message to be stored in database
         */
        public final void writeMessage(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.karan.shaadidotcom.model.Message message) {
        }
        
        /**
         * fill the given message in database table
         * @param db instance of db
         * @param message message to be stored in database
         * @throws IOException in case of error
         */
        private final void fillMessage(android.database.sqlite.SQLiteDatabase db, com.karan.shaadidotcom.model.Message message) throws java.io.IOException {
        }
        
        /**
         * Creates the content values to fill a message in database
         * @param message message to be filled
         * @return ContentValues containing writable data
         */
        private final android.content.ContentValues createContentValues(com.karan.shaadidotcom.model.Message message) {
            return null;
        }
        
        private final android.database.sqlite.SQLiteDatabase getReadableDatabase(android.content.Context context) {
            return null;
        }
        
        private final android.database.sqlite.SQLiteDatabase getWritableDatabase(android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}