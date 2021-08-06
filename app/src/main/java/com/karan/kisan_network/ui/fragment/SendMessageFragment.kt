package com.karan.kisan_network.ui.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.AsyncTask
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.Nullable
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.karan.kisan_network.R
import com.karan.kisan_network.database.DatabaseHelper
import com.karan.kisan_network.model.Contact
import com.karan.kisan_network.model.Message
import com.karan.kisan_network.ui.activity.MainActivity
import okhttp3.*
import java.io.IOException
import java.text.DateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [SendMessageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SendMessageFragment : Fragment() {
    private var mProgressBar // progress bar to show progress on message sending
            : ProgressBar? = null
    private var mSendOtpLayout // Linear layout to display while sending SMS
            : LinearLayout? = null
    private var mOtpAuthLayout // Linear layout to display while matching the OTP
            : LinearLayout? = null
    private var mInputOtp // TextView where OTP will be entered for matching
            : TextView? = null
    private var mSendBtn: Button? = null
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
        return inflater.inflate(R.layout.fragment_send_message, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inputName: TextView = view.findViewById<View>(R.id.show_name) as TextView
        val inputNumber: TextView = view.findViewById<View>(R.id.show_number) as TextView
        val profileImage = view.findViewById<View>(R.id.profile_image) as ImageView
        val profileImage2 = view.findViewById<View>(R.id.profile_image2) as ImageView
        mProgressBar = view.findViewById<View>(R.id.progressBar) as ProgressBar
        mOtpAuthLayout = view.findViewById<View>(R.id.layout_otp) as LinearLayout
        mSendOtpLayout = view.findViewById<View>(R.id.layout_sms) as LinearLayout
        mInputOtp = view.findViewById<View>(R.id.inputOtp) as TextView
        mSendBtn = view.findViewById<View>(R.id.btn_request_sms) as Button
        val verifyOtpBtn = view.findViewById<View>(R.id.btn_verify_otp) as Button
        val messageText: EditText = view.findViewById<View>(R.id.input_message) as EditText
        inputName.text = mContact?.fullName
        inputNumber.text = mContact?.number
        profileImage.setImageDrawable(mContact?.drawable)
        profileImage2.setImageDrawable(mContact?.drawable)
        mOtpCode = sixDigitRandomNumber
        val message: String = getString(R.string.msg_sms) + " " + mOtpCode
        messageText.setText(message)
        mSendBtn!!.setOnClickListener {
            sendMessage(messageText.text.toString())
            mProgressBar!!.isVisible = true
            mSendBtn!!.isEnabled = false
        }
        verifyOtpBtn.setOnClickListener { verifyOtp() }
    }

    /**
     * Activates OkHttp handler which sends the message and store it in database
     * @param message [Message] to be sent
     */
    private fun sendMessage(message: String) {
        if (isNetworkAvailable()) {
            val handler = OkHttpHandler(activity!!, mContact)
            handler.execute(message)
        } else {
            Toast.makeText(
                context,
                "Please make sure you are connected to internet",
                Toast.LENGTH_LONG
            ).show()

        }
    }// ran.nextInt(900000) gives a random number between 1 and 900000, that's why we have to add 100000

    /**
     * used to generate six digit random number for otp
     * @return six digit random number
     */
    private val sixDigitRandomNumber: String
        private get() {
            val ran = Random()
            // ran.nextInt(900000) gives a random number between 1 and 900000, that's why we have to add 100000
            val num = ran.nextInt(900000) + 100000
            return num.toString()
        }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        } else false
    }

    /**
     * Verify the OTP
     * show a toast and starts main activity after successful match
     * raises an error otherwise
     */
    private fun verifyOtp() {
        val otp: String = mInputOtp?.text.toString().trim { it <= ' ' }
        if (otp.isNotEmpty()) {
            if (otp != mOtpCode) {
                mInputOtp?.error = getString(R.string.msg_otp_not_equal)
            } else {
                Toast.makeText(context, "OTP matched", Toast.LENGTH_LONG).show()
                startActivity(Intent(context, MainActivity::class.java))
                activity?.finish()
            }
        } else {
            mInputOtp?.error = getString(R.string.msg_enter_otp)
            Toast.makeText(context, "Please enter the OTP", Toast.LENGTH_SHORT).show()
        }
    }

    inner class OkHttpHandler(context: Activity, contact: Contact?) :
        AsyncTask<String?, Void?, Boolean?>() {
        private val client: OkHttpClient = OkHttpClient()
        private val activity: Activity = context
        private val contact: Contact? = contact
        override fun doInBackground(vararg p0: String?): Boolean? {
            val toPhoneNumber: String? = contact?.number
            val message = p0[0]


            // update the otp code, just in the case user has decided to change it
            // replace all non-digits with nothing to read the otp code in message
            mOtpCode = message?.replace("\\D+".toRegex(), "")

            // it will be the timestamp
            val currentDateTime = DateFormat.getDateTimeInstance().format(Date())
            val url = "https://api.twilio.com/2010-04-01/Accounts/$ACCOUNT_SID/SMS/Messages"
            val base64EncodedCredentials = "Basic " + Base64.encodeToString(
                ("$ACCOUNT_SID:$AUTH_TOKEN").toByteArray(),
                Base64.NO_WRAP
            )
            val body: RequestBody = FormBody.Builder()
                .add("From", "+15734535375")
                .add("To", toPhoneNumber.toString())
                .add("Body", message.toString())
                .build()
            val request: Request = Request.Builder()
                .url(url)
                .post(body)
                .header("Authorization", base64EncodedCredentials)
                .build()
            try {
                val response: Response = client.newCall(request).execute()
                contact?.let { mOtpCode?.let { it1 -> Message(it, it1, currentDateTime) } }?.let {
                    DatabaseHelper.writeMessage(
                        activity.applicationContext,
                        it
                    )
                }
                Log.d(TAG, "sendSms: " + response.body!!.string())
                return true
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return false
        }

        override fun onPostExecute(result: Boolean?) {
            super.onPostExecute(result)
            if (result == true) {
                mProgressBar?.isVisible = false
                mSendOtpLayout?.isVisible = false
                mOtpAuthLayout?.isVisible = true
            } else {
                mProgressBar?.isVisible = false
                mSendBtn!!.isEnabled = true
                Toast.makeText(activity, "Error Occurred", Toast.LENGTH_LONG).show()
            }
        }


    }

    companion object {
        private const val TAG = "SendMessageFragment"

        // Its a potentially dangerous practice to put your account information in android app
        // as there is a chance that someone can decrypt the app and get this information
        // don't consider it for production.
        private const val ACCOUNT_SID = "ACedc0bb58fd076ad9ace6f5da6141500a" // Twilio account sid
        private const val AUTH_TOKEN = "5903d83bb773f380a9f1687462e38461" // Twilio auth token
        private var mOtpCode: String? = null

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param contact instance of [Contact].
         * @return A new instance of fragment SendMessageFragment.
         */
        fun newInstance(contact: Contact?): SendMessageFragment {
            val fragment = SendMessageFragment()
            val args = Bundle()
            args.putParcelable(Contact.TAG, contact)
            fragment.arguments = args
            return fragment
        }
    }
}