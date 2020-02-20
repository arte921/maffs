package arte921.maffs

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.view.*

class CanvasView(context: Context, attrs: AttributeSet): View(context, attrs) {
    private val plotColor = ResourcesCompat.getColor(resources,R.color.plotColor,null)
    private val angleTextColor = ResourcesCompat.getColor(resources,R.color.angleTextColor,null)
    private val lengthTextColor = ResourcesCompat.getColor(resources,R.color.angleTextColor,null)

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

        canvas.drawLine(10.0F, maxy - 10.0F, (mt.a + 10.0).toFloat(),maxy - 10.0F,plotPaint)

    }
}