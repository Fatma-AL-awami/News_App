package com.example.news_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import json_news.news_details
import java.util.*

class NewsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EAdapter
    private lateinit var EviewModel:NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EviewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        recyclerView = view.findViewById(R.id.quake_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        EviewModel.quakesLiveData.observe(
            viewLifecycleOwner,
            Observer { Features ->
//                Toast.makeText(context, features[0].id, Toast.LENGTH_LONG).show()
               // updateUI(Features)
            })
    }

    private fun updateUI(Features: List<news_details>) {
        adapter = EAdapter(Features)
        recyclerView.adapter = adapter
    }
    companion object {

        fun newInstance() = NewsFragment()
    }
    private class EHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val titleView = itemView.findViewById(R.id.title) as TextView
        private val detailsView = itemView.findViewById(R.id.details_news) as TextView


        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

        fun bind(fe: news_details) {

         titleView.text=fe.title
            detailsView.text=fe.details

        }
    }

    private class EAdapter(private val PropertiesItems: List<news_details>) :
        RecyclerView.Adapter<EHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): EHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
            return EHolder(view)
        }

        override fun getItemCount(): Int = PropertiesItems.size

        override fun onBindViewHolder(holder: EHolder, position: Int) {
            val features = PropertiesItems[position]
            holder.bind(features)
        }
    }
}