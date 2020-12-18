package com.adni.contacts_list.listener

interface OnCallListener<T> {

    fun onCall(t: T)

    fun onMessage(t: T)
}