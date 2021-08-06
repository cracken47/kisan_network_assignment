package com.karan.shaadidotcom.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.karan.shaadidotcom.R
import com.karan.shaadidotcom.model.Contact
import com.karan.shaadidotcom.ui.activity.SendMessageActivity

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the [ShowProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowProfileFragment : Fragment() {
    //    private OnFragmentInteractionListener mListener;
    private var mContact: Contact? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mContact = arguments?.getParcelable(Contact.TAG)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_profile, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView = view.findViewById<View>(R.id.contact_image) as ImageView
        val contactNameView: TextView = view.findViewById<View>(R.id.contact_name) as TextView
        val contactNumberView: TextView = view.findViewById<View>(R.id.contact_number) as TextView
        val btnNewActivity = view.findViewById<View>(R.id.new_message_btn) as Button
        imageView.setImageDrawable(mContact?.drawable)
        contactNameView.text = mContact?.fullName
        contactNumberView.text = mContact?.number
        btnNewActivity.setOnClickListener {
            startActivity(SendMessageActivity.getStartIntent(context, mContact))
            activity?.finish()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param contact instance of [.model.Contact].
         * @return A new instance of fragment ShowProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(contact: Contact?): ShowProfileFragment {
            val fragment = ShowProfileFragment()
            val args = Bundle()
            args.putParcelable(Contact.TAG, contact)
            fragment.arguments = args
            return fragment
        }
    }
}