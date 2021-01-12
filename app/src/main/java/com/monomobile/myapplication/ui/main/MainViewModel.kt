package com.monomobile.myapplication.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    fun getInitialHeight(): Int = 200
    fun getInitialWidth(): Int = 400
}