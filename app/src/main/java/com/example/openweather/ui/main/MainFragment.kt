package com.example.openweather.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.example.openweather.R
import com.example.openweather.ui.weather.WeatherFragment
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = MainFragment()
        const val EXTRA_USER = "EXTRA_USER"
        const val EXTRA_POSTAL = "EXTRA_POSTAL"
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        btn_check_weather.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_check_weather -> {
                val weatherFragment = WeatherFragment()
                val mBundle = Bundle()
                val username = et_username.text.toString().trim()
                val postal = et_postal_code.text.toString().trim()
                mBundle.putString(EXTRA_USER, username)
                mBundle.putString(EXTRA_POSTAL, postal)

                weatherFragment.arguments = mBundle

                val mfragmentManager = fragmentManager as FragmentManager
                mfragmentManager.beginTransaction()
                    .replace(
                        R.id.container,
                        weatherFragment,
                        WeatherFragment::class.java.simpleName
                    )
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}
