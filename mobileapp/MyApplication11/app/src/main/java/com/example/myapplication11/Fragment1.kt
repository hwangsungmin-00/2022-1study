package com.example.myapplication11

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication11.databinding.Fragment1Binding
import com.example.myapplication11.databinding.ItemRecyclerviewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */

class MyViewHolder(val binding : ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)
class MyAdapter(val datas:MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return datas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //TODO("Not yet implemented")
        return MyViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //TODO("Not yet implemented")
        val binding=(holder as MyViewHolder).binding
        binding.itemTv.text=datas[position]
    }
}

class MyDecoration(val context: Context) : RecyclerView.ItemDecoration(){
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        //c.drawBitmap(BitmapFactory.decodeResource(context.resources, R.drawable.stadium), 0f, 0f, null)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        //스마트폰의 크기/2-이미지크기/2
        val width=parent.width
        val height=parent.height

        val dr:Drawable? = ResourcesCompat.getDrawable(context.resources, R.drawable.kbo, null)
        val d_width=dr?.intrinsicWidth
        val d_height=dr?.intrinsicHeight

        val left = width/2-d_width?.div(2) as Int
        val top = height/2-d_height?.div(2) as Int
        c.drawBitmap(BitmapFactory.decodeResource(context.resources, R.drawable.kbo), left.toFloat(), top.toFloat(), null)

    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(10, 10, 10, 0)
        view.setBackgroundColor(Color.parseColor("#49c1ff"))
        ViewCompat.setElevation(view, 20.0f)
    }
}
class Fragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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

        val datas = mutableListOf<String>()
        for(i in 1..9){
            datas.add("item $i")
        }
        val binding = Fragment1Binding.inflate(inflater, container, false)
        val layoutManager = LinearLayoutManager(activity)
        //layoutManager.orientation=LinearLayoutManager.HORIZONTAL
        //val layoutManager = GridLayoutManager(activity, 2)
        binding.recyclerView.layoutManager=layoutManager
        binding.recyclerView.adapter=MyAdapter(datas)
        binding.recyclerView.addItemDecoration(MyDecoration(activity as Context))

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}