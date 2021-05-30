package com.example.projetesiea.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetesiea.R
import com.example.projetesiea.presentation.list.Players.Players
import com.example.projetesiea.presentation.list.api.NbaApi
import com.example.projetesiea.presentation.list.api.NbaPlayers
import com.example.projetesiea.presentation.list.api.NbaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NBAListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = NBAAdapter(listOf(), ::onClickedNbaPlayers)

    fun onClickedNbaPlayers(nbaPlayers: NbaPlayers) {
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }


    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shoes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.shoes_recyclerview)

        val apply = recyclerView.apply {
            layoutManager = this@NBAListFragment.layoutManager
            adapter = this@NBAListFragment.adapter
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.balldontlie.io/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val nbaApi : NbaApi = retrofit.create(NbaApi::class.java)

        nbaApi.getShoesList().enqueue(object: Callback<NbaResponse>{
            override fun onFailure(call: Call<NbaResponse>, t: Throwable) {

                //TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<NbaResponse>, response: Response<NbaResponse>) {
                if(response.isSuccessful && response.body() != null){
                   val nbaResponse = response.body()!!
                    adapter.updateList(nbaResponse.data)
                }
                //TODO("Not yet implemented")
            }

        } )




    }
}




