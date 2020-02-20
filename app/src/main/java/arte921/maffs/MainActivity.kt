package arte921.maffs

//TODO: strings voor hints in mainActivity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
var mt: triangle = triangle(10.0,10.0,10.0,-1.0,-1.0,-1.0)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculate(view: View){

        plotcanvas.invalidate()
    }
}
