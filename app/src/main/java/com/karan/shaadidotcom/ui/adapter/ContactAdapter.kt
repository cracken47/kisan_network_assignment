package com.karan.shaadidotcom.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.karan.shaadidotcom.R
import com.karan.shaadidotcom.model.Contact

/**
 *
 * Adapter class used to populate RecyclerView
 */
class ContactAdapter(private val mContext: Context, contactList: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder?>() {
    private val mContactList: List<Contact> = contactList
    private var mClickListener: OnItemClickListener? = null

    /**
     * Interface used to create on click listener
     */
    interface OnItemClickListener {
        fun onClick(view: View?, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.getContext()).inflate(
            R.layout.item_contact_card,
            parent, false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact: Contact = mContactList[position]
        holder.contactName.setText(contact.fullName) // full name of contact
        holder.contactNumber.setText(contact.number) // contact number
        holder.contactImage.setImageDrawable(contact.drawable) // text drawable, just like in Gmail

        // sets on click listener on each item
        holder.itemView.setOnClickListener(View.OnClickListener { view ->
            mClickListener!!.onClick(
                view,
                holder.getAdapterPosition()
            )
        })
    }

    override fun getItemCount(): Int {
        return mContactList.size
    }

    /**
     * Use this public method to set on click listener
     * @param clickListener implements interface [OnItemClickListener]
     */
    fun setOnItemClickListener(clickListener: OnItemClickListener?) {
        mClickListener = clickListener
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactImage // ImageView where, text drawable will be populated
                : ImageView = itemView.findViewById<View>(R.id.contact_image) as ImageView
        val contactName // TextView to show contact name
                : TextView = itemView.findViewById<View>(R.id.contact_name) as TextView
        val contactNumber // TextView to show contact number
                : TextView = itemView.findViewById<View>(R.id.contact_number) as TextView

    }

}