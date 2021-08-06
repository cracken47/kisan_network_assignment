package com.karan.shaadidotcom.ui.fragment;

import java.lang.System;

/**
 * Fragment class that shows a list containing all contacts
 */
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0017J\u001c\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0002J \u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0002R\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001d"}, d2 = {"Lcom/karan/shaadidotcom/ui/fragment/ContactFragment;", "Landroidx/fragment/app/Fragment;", "()V", "contactList1", "", "Lcom/karan/shaadidotcom/model/Contact;", "getContactList1", "()Ljava/util/List;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "readContactsFromResources", "", "setOnclickListener", "subjectAdapter", "Lcom/karan/shaadidotcom/ui/adapter/ContactAdapter;", "contactList", "setupRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "app_debug"})
public final class ContactFragment extends androidx.fragment.app.Fragment {
    private static final java.lang.String TAG = "ContactFragment";
    @org.jetbrains.annotations.NotNull()
    public static final com.karan.shaadidotcom.ui.fragment.ContactFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null (which
     * is the default implementation).  This will be called between
     * [.onCreate] and [.onActivityCreated].
     *
     *
     *
     * If you return a View from here, you will later be called in
     * [.onDestroyView] when the view is being released.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    /**
     * Called immediately after [.onCreateView]
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     *
     * @param view               The View returned by [.onCreateView].
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     */
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView, java.util.List<com.karan.shaadidotcom.model.Contact> contactList) {
    }
    
    private final void setOnclickListener(com.karan.shaadidotcom.ui.adapter.ContactAdapter subjectAdapter, java.util.List<com.karan.shaadidotcom.model.Contact> contactList) {
    }
    
    /**
     * reads contact json file
     * @return string containing [Contact] in json format
     * @throws IOException in case any exception occurs
     */
    private final java.lang.String readContactsFromResources() throws java.io.IOException {
        return null;
    }
    
    private final java.util.List<com.karan.shaadidotcom.model.Contact> getContactList1() {
        return null;
    }
    
    public ContactFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/karan/shaadidotcom/ui/fragment/ContactFragment$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/karan/shaadidotcom/ui/fragment/ContactFragment;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.karan.shaadidotcom.ui.fragment.ContactFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}