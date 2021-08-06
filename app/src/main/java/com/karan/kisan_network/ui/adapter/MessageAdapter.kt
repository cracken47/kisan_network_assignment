package com.karan.kisan_network.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.karan.kisan_network.R
import com.karan.kisan_network.model.Contact
import com.karan.kisan_network.model.Message

/**
 * Adapter class used to populate RecycleView
 * with a list of [Message]
 */
class MessageAdapter(private val mContext: Context, messageList: List<Message>) :
    RecyclerView.Adapter<MessageAdapter.ViewHolder?>() {
    private val mMessageList: List<Message> = messageList
    private val mClickListener: ContactAdapter.OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_message_card,
            parent, false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val size = mMessageList.size

        // as message should be in descending order of date and time
        val message: Message = mMessageList[size - position - 1]
        val contact: Contact = message.contact
        holder.contactName.text = contact.fullName
        holder.contactNumber.text = contact.number
        holder.contactImage.setImageDrawable(contact.drawable)
        holder.messageTime.text = message.timestamp
        holder.otpCode.text = "Sent OTP : " + message.otpCode
    }

    override fun getItemCount(): Int {
        return mMessageList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactImage // ImageView to populate text drawable
                : ImageView = itemView.findViewById<View>(R.id.contact_image) as ImageView
        val contactName // TextView to set contact name
                : TextView = itemView.findViewById<View>(R.id.contact_name) as TextView
        val contactNumber // TextView to set contact Number
                : TextView = itemView.findViewById<View>(R.id.contact_number) as TextView
        val messageTime // TextView to set time at which message had been sent
                : TextView = itemView.findViewById<View>(R.id.message_timestamp) as TextView
        val otpCode // TextView to set sent OTP code
                : TextView = itemView.findViewById<View>(R.id.message_otp) as TextView

    }

}