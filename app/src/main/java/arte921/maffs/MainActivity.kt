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

        mt = triangle(
            if(edita.text.toString().trim().isNotBlank() && edita.text.toString().trim().toDouble() > 0) edita.text.toString().trim().toDouble()/180 * PI else -1.0,
            if(editb.text.toString().trim().isNotBlank() && editb.text.toString().trim().toDouble() > 0) editb.text.toString().trim().toDouble()/180 * PI else -1.0,
            if(editc.text.toString().trim().isNotBlank() && editc.text.toString().trim().toDouble() > 0) editc.text.toString().trim().toDouble()/180 * PI else -1.0,
            if(editalfa.text.toString().trim().isNotBlank() && editalfa.text.toString().trim().toDouble() > 0) editalfa.text.toString().trim().toDouble()/180 * PI else -1.0,
            if(editbeta.text.toString().trim().isNotBlank() && editbeta.text.toString().trim().toDouble() > 0) editbeta.text.toString().trim().toDouble()/180 * PI else -1.0,
            if(editgamma.text.toString().trim().isNotBlank() && editgamma.text.toString().trim().toDouble() > 0) editgamma.text.toString().trim().toDouble()/180 * PI else -1.0)

        mt.calculate()


        edita.setText(mt.a.toString())
        editb.setText(mt.b.toString())
        editc.setText(mt.c.toString())
        editalfa.setText((mt.alfa / PI * 180).toString())
        editbeta.setText((mt.beta / PI * 180).toString())
        editgamma.setText((mt.gamma / PI * 180).toString())

        plotcanvas.invalidate()
    }

    fun clear(view: View){
        edita.text.clear()
        editb.text.clear()
        editc.text.clear()
        editalfa.text.clear()
        editbeta.text.clear()
        editgamma.text.clear()
    }
}
