package com.karan.kisan_network.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator

@Entity(tableName = "contact_table")
class Contact : Parcelable {
    private var mFirstName // first name of the contact
            : String? = null
    private var mLastName // last name of the contact
            : String? = null
    var fullName // full name of the contact
            : String? = null
        private set
    var number // mobile number of the contact
            : String? = null
        private set
    var color // color used to draw contact image
            = 0
        private set

    constructor(firstName: String, lastName: String, number: String?) {
        mFirstName = firstName
        mLastName = lastName
        Contact("$firstName $lastName", number)
    }

    constructor(fullName: String?, number: String?) {
        this.fullName = fullName
        this.number = number
        color = setRandomColor()
    }

    constructor(`in`: Parcel) {
        mFirstName = `in`.readString()
        mLastName = `in`.readString()
        fullName = `in`.readString()
        number = `in`.readString()
        color = `in`.readInt()
    }

    val lastName: String
        get() = mLastName ?: ""
    val firstName: String?
        get() = if (mFirstName != null) {
            mFirstName
        } else fullName
    val drawable: TextDrawable
        get() {
            val builder = TextDrawable.builder()
                .beginConfig()
                .withBorder(4)
                .endConfig()
                .round()
            return builder.build(nameInitial, color)
        }

    /**
     * used to create Gmail like contact image
     * @return first letter of name
     */
    val nameInitial: String
        get() = firstName!![0].toString()

    private fun setRandomColor(): Int {
        val generator = ColorGenerator.MATERIAL
        return generator.randomColor
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, i: Int) {
        dest.writeString(firstName)
        dest.writeString(lastName)
        dest.writeString(fullName)
        dest.writeString(number)
        dest.writeInt(color)
    }

    companion object {
        const val TAG = "Contact"
        @JvmField val CREATOR: Parcelable.Creator<Contact?> = object : Parcelable.Creator<Contact?> {
            override fun createFromParcel(`in`: Parcel): Contact? {
                return Contact(`in`)
            }

            override fun newArray(size: Int): Array<Contact?> {
                return arrayOfNulls(size)
            }
        }
    }
}