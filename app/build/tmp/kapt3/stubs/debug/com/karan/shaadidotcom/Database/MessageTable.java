package com.karan.shaadidotcom.Database;

import java.lang.System;

/**
 * Interface used to Create and Populate Message in database
 */
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/karan/shaadidotcom/Database/MessageTable;", "", "Companion", "app_debug"})
public abstract interface MessageTable {
    @org.jetbrains.annotations.NotNull()
    public static final com.karan.shaadidotcom.Database.MessageTable.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NAME = "message";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLUMN_ID = "_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLUMN_NAME = "contact_name";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLUMN_NUMBER = "contact_number";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLUMN_TIMESTAMP = "timestamp";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLUMN_OTP = "otp";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CREATE = "CREATE TABLE message (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, contact_name TEXT NOT NULL, contact_number TEXT NOT NULL, timestamp TEXT NOT NULL, otp TEXT NOT NULL);";
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/karan/shaadidotcom/Database/MessageTable$Companion;", "", "()V", "COLUMN_ID", "", "COLUMN_NAME", "COLUMN_NUMBER", "COLUMN_OTP", "COLUMN_TIMESTAMP", "CREATE", "NAME", "PROJECTION", "", "getPROJECTION", "()[Ljava/lang/String;", "[Ljava/lang/String;", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NAME = "message";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String COLUMN_ID = "_id";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String COLUMN_NAME = "contact_name";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String COLUMN_NUMBER = "contact_number";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String COLUMN_TIMESTAMP = "timestamp";
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String COLUMN_OTP = "otp";
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String[] PROJECTION = {"_id", "contact_name", "contact_number", "timestamp", "otp"};
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String CREATE = "CREATE TABLE message (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, contact_name TEXT NOT NULL, contact_number TEXT NOT NULL, timestamp TEXT NOT NULL, otp TEXT NOT NULL);";
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String[] getPROJECTION() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}