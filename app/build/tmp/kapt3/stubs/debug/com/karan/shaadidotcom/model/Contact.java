package com.karan.shaadidotcom.model;

import java.lang.System;

/**
 * Created by ujjawal on 15/7/17.
 */
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\rH\u0016R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016\u00a8\u0006%"}, d2 = {"Lcom/karan/shaadidotcom/model/Contact;", "Landroid/os/Parcelable;", "firstName", "", "lastName", "number", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "fullName", "(Ljava/lang/String;Ljava/lang/String;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "<set-?>", "", "color", "getColor", "()I", "drawable", "Lcom/amulyakhare/textdrawable/TextDrawable;", "getDrawable", "()Lcom/amulyakhare/textdrawable/TextDrawable;", "getFirstName", "()Ljava/lang/String;", "getFullName", "getLastName", "mFirstName", "mLastName", "nameInitial", "getNameInitial", "getNumber", "describeContents", "setRandomColor", "writeToParcel", "", "dest", "i", "Companion", "app_debug"})
public final class Contact implements android.os.Parcelable {
    private java.lang.String mFirstName;
    private java.lang.String mLastName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String fullName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String number;
    private int color = 0;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "Contact";
    @org.jetbrains.annotations.NotNull()
    public static final android.os.Parcelable.Creator<com.karan.shaadidotcom.model.Contact> CREATOR = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.karan.shaadidotcom.model.Contact.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFullName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNumber() {
        return null;
    }
    
    public final int getColor() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLastName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFirstName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.amulyakhare.textdrawable.TextDrawable getDrawable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNameInitial() {
        return null;
    }
    
    private final int setRandomColor() {
        return 0;
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel dest, int i) {
    }
    
    public Contact(@org.jetbrains.annotations.NotNull()
    java.lang.String firstName, @org.jetbrains.annotations.NotNull()
    java.lang.String lastName, @org.jetbrains.annotations.Nullable()
    java.lang.String number) {
        super();
    }
    
    public Contact(@org.jetbrains.annotations.Nullable()
    java.lang.String fullName, @org.jetbrains.annotations.Nullable()
    java.lang.String number) {
        super();
    }
    
    public Contact(@org.jetbrains.annotations.NotNull()
    android.os.Parcel in) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/karan/shaadidotcom/model/Contact$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/karan/shaadidotcom/model/Contact;", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}