package com.aayush.fragments

import android.content.Context
import android.graphics.Color.red
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_First.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_First : Fragment(),ActivityInterface{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var initView:View
    lateinit var tvHello: TextView
    lateinit var ll: LinearLayout
    lateinit var fragmentActivity: com.aayush.fragments.FragmentActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentActivity = activity as com.aayush.fragments.FragmentActivity
        fragmentActivity.activityInterface=this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        initView= inflater.inflate(R.layout.fragment__first, container, false)
        return initView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment_First.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_First().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvHello =initView.findViewById(R.id.tvHello)
        ll=initView.findViewById(R.id.ll)
        tvHello.setOnClickListener {
            fragmentActivity.showToast()
        }
    }

    override fun ActivityInterface(color:Int,i:Int){
        tvHello.setText("Changed color $i times")
        when (color){
            1->{
                ll.setBackgroundColor(ContextCompat.getColor(fragmentActivity,R.color.red))
                 }
            2->{
                ll.setBackgroundColor(ContextCompat.getColor(fragmentActivity,R.color.green))
            }
            3->{
            ll.setBackgroundColor(ContextCompat.getColor(fragmentActivity,R.color.yellow))
            }
            else->{}
        }
    }
}