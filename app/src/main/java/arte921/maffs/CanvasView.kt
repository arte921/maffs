package arte921.maffs

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.math.cos
import kotlin.math.sin

class CanvasView(context: Context, attrs: AttributeSet): View(context, attrs) {
    private val plotColor = ResourcesCompat.getColor(resources,R.color.plotColor,null)
    private val angleTextColor = ResourcesCompat.getColor(resources,R.color.angleTextColor,null)
    private val lengthTextColor = ResourcesCompat.getColor(resources,R.color.angleTextColor,null)
    private var nmarigin: Double = 0.0
    private var smarigin: Double = 0.0
    private var emarigin: Double = 0.0
    private var wmarigin: Double = 0.0
    private var cosadj: Double = 0.0

    private var res: Double = 1.0

    private var maxx: Int = 0
    private var maxy: Int = 0

    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap

    private val Strkw = 10.0F

    private val plotPaint = Paint().apply {
        color = plotColor
        isAntiAlias = true
        isDither = true
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = Strkw
    }

    override fun onSizeChanged(width:Int,height:Int,oldWidth:Int,oldHeight:Int) {
        super.onSizeChanged(width,height,oldWidth,oldHeight)
        if(::extraBitmap.isInitialized) extraBitmap.recycle()
        extraBitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(plotColor)

        maxx = width
        maxy = height
    }

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)
        reset()

        cosadj = if(cos(mt.alfa) < 0) -cos(mt.alfa) * mt.b else 0.0

        res = if(sin(mt.alfa)/(mt.c+cosadj) < ((maxy-nmarigin-smarigin)/(maxx-wmarigin-emarigin))) maxx/(mt.c+cosadj) else maxy/sin(mt.alfa)

        wmarigin += cosadj*res
        Log.i("cosadj: ",wmarigin.toString())

        canvas.drawLine(wmarigin.toFloat(),(maxy-nmarigin).toFloat(),(mt.c * res + wmarigin).toFloat(),(maxy-nmarigin).toFloat(),plotPaint)
        canvas.drawLine(wmarigin.toFloat(),(maxy-nmarigin).toFloat(),(wmarigin + cos(mt.alfa)*mt.b*res).toFloat(),(maxy-sin(mt.alfa)*mt.b*res).toFloat(),plotPaint)
        //canvas.drawLine((wmarigin + cos(mt.alfa)*mt.b*res).toFloat(),(maxy-sin(mt.alfa)*mt.b*res).toFloat(),(mt.c * res + wmarigin).toFloat(),(maxy-nmarigin).toFloat(),plotPaint)
    }

    fun reset(){
        nmarigin = 10.0
        smarigin = 10.0
        emarigin = 10.0
        wmarigin = 10.0
    }
}