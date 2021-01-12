package com.monomobile.myapplication.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.monomobile.myapplication.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        val rectangleView: View? = activity?.findViewById(R.id.rectangleView)
        var y = 0.0
        val listener = View.OnTouchListener { view, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_MOVE) {
                val height = rectangleView?.layoutParams?.height ?: 0
                if(motionEvent.rawY < y && y != 0.0) {
                    rectangleView?.layoutParams?.height = height + 10
                } else {
                    rectangleView?.layoutParams?.height = height - 10
                }

                y = motionEvent.rawY.toDouble()
                rectangleView?.forceLayout()
                rectangleView?.parent?.requestLayout();
            }

            true
        }

        rectangleView?.let {
            it.layoutParams.width = viewModel.getInitialWidth()
            it.layoutParams.height = viewModel.getInitialHeight()
            it.setOnTouchListener(listener)
        }
    }


}