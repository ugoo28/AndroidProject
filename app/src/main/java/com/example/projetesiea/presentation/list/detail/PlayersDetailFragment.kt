package com.example.projetesiea.presentation.list.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.projetesiea.R
import com.example.projetesiea.presentation.list.Singletons
import com.example.projetesiea.presentation.list.Singletons.Companion.nbaApi
import com.example.projetesiea.presentation.list.api.NbaPlayers
import com.example.projetesiea.presentation.list.api.PlayersDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PlayersDetailFragment : Fragment() {

    private lateinit var textViewName: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.players_detail)
        callApi()

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    private fun callApi() {
        nbaApi.getPlayersDetail("2").enqueue(object : Callback<NbaPlayers>{
            override fun onFailure(
                    call: Call<NbaPlayers>,
                    t: Throwable
            ) {

            }

            override fun onResponse(
                    call: Call<NbaPlayers>,
                    response: Response<NbaPlayers>
            ) {
                if(response.isSuccessful && response.body() != null){
                    val resp = response.body()!!
                    textViewName.text = resp.team.city
                }
            }

        })
    }
}

private fun <T> Call<T>.enqueue(callback: Callback<NbaPlayers>) {

}


