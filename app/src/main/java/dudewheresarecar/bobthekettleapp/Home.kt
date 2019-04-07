package dudewheresarecar.bobthekettleapp

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast


class Home : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = Home()
    }

    private lateinit var viewModel: NetworkViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.home_fragment, container, false)


        val getTempButton = view.findViewById<Button>(R.id.button)
        val setTempButton = view.findViewById<Button>(R.id.button2)

        getTempButton.setOnClickListener(this)
        setTempButton.setOnClickListener(this)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NetworkViewModel::class.java)
    }

    override fun onClick(v: View) {
        when (v?.id) {
            R.id.button -> {
                viewModel.getFromServer("0.0.0.0:5000/temperature/get")
            }
            R.id.button2 -> {
                viewModel.postToServer("0.0.0.0:5000/temperature/hot", "data")
            }
            else -> {
                val text = "Hello toast!"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(context, text, duration)
                toast.show()
            }
        }
    }

}
