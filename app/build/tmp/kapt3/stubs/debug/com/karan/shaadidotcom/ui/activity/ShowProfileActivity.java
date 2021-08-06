package com.karan.shaadidotcom.ui.activity;

import java.lang.System;

/**
 * shows contact information
 */
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014\u00a8\u0006\f"}, d2 = {"Lcom/karan/shaadidotcom/ui/activity/ShowProfileActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "attachFragment", "", "contact", "Lcom/karan/shaadidotcom/model/Contact;", "initToolbar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class ShowProfileActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final com.karan.shaadidotcom.ui.activity.ShowProfileActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initToolbar() {
    }
    
    /**
     * Attaches the view fragment
     * @param contact [Contact] you want to display in the view
     */
    private final void attachFragment(com.karan.shaadidotcom.model.Contact contact) {
    }
    
    public ShowProfileActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a8\u0006\t"}, d2 = {"Lcom/karan/shaadidotcom/ui/activity/ShowProfileActivity$Companion;", "", "()V", "getStartIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "contact", "Lcom/karan/shaadidotcom/model/Contact;", "app_debug"})
    public static final class Companion {
        
        /**
         * Use this public method to create instance of this class
         * @param context context in which this is running
         * @param contact [Contact] To which you want to  send message
         * @return Intent of the [ShowProfileActivity]
         */
        @org.jetbrains.annotations.NotNull()
        public final android.content.Intent getStartIntent(@org.jetbrains.annotations.Nullable()
        android.content.Context context, @org.jetbrains.annotations.Nullable()
        com.karan.shaadidotcom.model.Contact contact) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}