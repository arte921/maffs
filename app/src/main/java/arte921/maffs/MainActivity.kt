package arte921.maffs

//TODO: strings voor hints in mainActivity

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.PI

var mt: triangle = triangle(20.0,10.0,15.0,-1.0,-1.0,-1.0)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun calculate(view: View){
        mt.calculate()


        edita.setText(mt.a.toString())
        editb.setText(mt.b.toString())
        editc.setText(mt.c.toString())
        editalfa.setText((mt.alfa / PI * 180).toString())
        editbeta.setText((mt.beta / PI * 180).toString())
        editgamma.setText((mt.gamma / PI * 180).toString())

        plotcanvas.invalidate()
    }
}
