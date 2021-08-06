package com.karan.shaadidotcom.ui.fragment;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [SendMessageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00172\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\u0013H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006#"}, d2 = {"Lcom/karan/shaadidotcom/ui/fragment/SendMessageFragment;", "Landroidx/fragment/app/Fragment;", "()V", "mContact", "Lcom/karan/shaadidotcom/model/Contact;", "mInputOtp", "Landroid/widget/TextView;", "mOtpAuthLayout", "Landroid/widget/LinearLayout;", "mProgressBar", "Landroid/widget/ProgressBar;", "mSendBtn", "Landroid/widget/Button;", "mSendOtpLayout", "sixDigitRandomNumber", "", "getSixDigitRandomNumber", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "sendMessage", "message", "verifyOtp", "Companion", "OkHttpHandler", "app_debug"})
public final class SendMessageFragment extends androidx.fragment.app.Fragment {
    private android.widget.ProgressBar mProgressBar;
    private android.widget.LinearLayout mSendOtpLayout;
    private android.widget.LinearLayout mOtpAuthLayout;
    private android.widget.TextView mInputOtp;
    private android.widget.Button mSendBtn;
    private com.karan.shaadidotcom.model.Contact mContact;
    private static final java.lang.String TAG = "SendMessageFragment";
    private static final java.lang.String ACCOUNT_SID = "ACedc0bb58fd076ad9ace6f5da6141500a";
    private static final java.lang.String AUTH_TOKEN = "5903d83bb773f380a9f1687462e38461";
    private static java.lang.String mOtpCode;
    @org.jetbrains.annotations.NotNull()
    public static final com.karan.shaadidotcom.ui.fragment.SendMessageFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Activates OkHttp handler which sends the message and store it in database
     * @param message [Message] to be sent
     */
    private final void sendMessage(java.lang.String message) {
    }
    
    private final java.lang.String getSixDigitRandomNumber() {
        return null;
    }
    
    /**
     * Verify the OTP
     * show a toast and starts main activity after successful match
     * raises an error otherwise
     */
    private final void verifyOtp() {
    }
    
    public SendMessageFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\'\u0010\r\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u000f\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0014\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/karan/shaadidotcom/ui/fragment/SendMessageFragment$OkHttpHandler;", "Landroid/os/AsyncTask;", "", "Ljava/lang/Void;", "", "context", "Landroid/app/Activity;", "contact", "Lcom/karan/shaadidotcom/model/Contact;", "(Lcom/karan/shaadidotcom/ui/fragment/SendMessageFragment;Landroid/app/Activity;Lcom/karan/shaadidotcom/model/Contact;)V", "activity", "client", "Lokhttp3/OkHttpClient;", "doInBackground", "p0", "", "([Ljava/lang/String;)Ljava/lang/Boolean;", "onPostExecute", "", "result", "(Ljava/lang/Boolean;)V", "app_debug"})
    public final class OkHttpHandler extends android.os.AsyncTask<java.lang.String, java.lang.Void, java.lang.Boolean> {
        private final okhttp3.OkHttpClient client = null;
        private final android.app.Activity activity = null;
        private final com.karan.shaadidotcom.model.Contact contact = null;
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        protected java.lang.Boolean doInBackground(@org.jetbrains.annotations.NotNull()
        java.lang.String... p0) {
            return null;
        }
        
        @java.lang.Override()
        protected void onPostExecute(@org.jetbrains.annotations.Nullable()
        java.lang.Boolean result) {
        }
        
        public OkHttpHandler(@org.jetbrains.annotations.NotNull()
        android.app.Activity context, @org.jetbrains.annotations.Nullable()
        com.karan.shaadidotcom.model.Contact contact) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/karan/shaadidotcom/ui/fragment/SendMessageFragment$Companion;", "", "()V", "ACCOUNT_SID", "", "AUTH_TOKEN", "TAG", "mOtpCode", "newInstance", "Lcom/karan/shaadidotcom/ui/fragment/SendMessageFragment;", "contact", "Lcom/karan/shaadidotcom/model/Contact;", "app_debug"})
    public static final class Companion {
        
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param contact instance of [Contact].
         * @return A new instance of fragment SendMessageFragment.
         */
        @org.jetbrains.annotations.NotNull()
        public final com.karan.shaadidotcom.ui.fragment.SendMessageFragment newInstance(@org.jetbrains.annotations.Nullable()
        com.karan.shaadidotcom.model.Contact contact) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}