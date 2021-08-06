package com.karan.shaadidotcom.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.Nullable
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.karan.shaadidotcom.database.DatabaseHelper.Companion.getMessages
import com.karan.shaadidotcom.ui.adapter.MessageAdapter
import com.karan.shaadidotcom.R
import com.karan.shaadidotcom.model.Message

/**
 * Populates Message tab
 * with list of already sent messages
 */
class MessageFragment : Fragment() {
    private var mRecyclerView: RecyclerView? = null
    private var mLinearLayout: LinearLayout? = null

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
    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_recycleview, container, false)
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
    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRecyclerView = view.findViewById<View>(R.id.recyclerView) as RecyclerView
        mLinearLayout = view.findViewById<View>(R.id.layout_no_data) as LinearLayout
    }

    /**
     * Populates the view with messages stored in database
     * Putting this here helps in retrieving all the recent changes in database table
     */
    override fun onResume() {
        super.onResume()
        val messageList: List<Message>? = getMessages(context!!, true)
        mLinearLayout?.isVisible = false
        messageList?.let { setupRecyclerView(it) }
    }

    private fun setupRecyclerView(messageList: List<Message>) {
        val adapter = context?.let { MessageAdapter(it, messageList) }
        val linearLayoutManager = LinearLayoutManager(getActivity())
        mRecyclerView?.layoutManager = linearLayoutManager
        mRecyclerView?.adapter=adapter
    }

    companion object {
        /**
         * use this public method to create instance of this class
         * @return [MessageFragment]
         */
        fun newInstance(): MessageFragment {
            return MessageFragment()
        }
    }
}