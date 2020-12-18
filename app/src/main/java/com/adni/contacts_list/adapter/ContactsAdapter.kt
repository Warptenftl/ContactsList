package com.adni.contacts_list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adni.contacts_list.R
import com.adni.contacts_list.listener.OnCallListener
import com.adni.contacts_list.model.Contact

class ContactsAdapter(private val contactList: ArrayList<Contact>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    private var onCallListener: OnCallListener<Contact>? = null

    fun setListener(onCallListener: OnCallListener<Contact>) {
        this.onCallListener = onCallListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contactList[position]
        holder.bindItems(contact)
        holder.itemView.findViewById<ImageButton>(R.id.ibCall).setOnClickListener {
            if (onCallListener != null) {
                onCallListener!!.onCall(contact)
            }
        }
        holder.itemView.findViewById<ImageButton>(R.id.ibMessage).setOnClickListener {
            if (onCallListener != null) {
                onCallListener!!.onMessage(contact)
            }
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(contact: Contact) {
            val tvName = itemView.findViewById<TextView>(R.id.tvName)
            val tvNumber = itemView.findViewById<TextView>(R.id.tvNumber)
            tvName.text = contact.name
            tvNumber.text = contact.number
        }
    }
}