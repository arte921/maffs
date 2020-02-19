package arte921.maffs

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View
import androidx.core.content.res.ResourcesCompat

class CanvasView(context: Context): View(context) {
    private val strokeWidth = 10

    private val plotColor = ResourcesCompat.getColor(resources,R.color.plotColor,null)
    private val angleTextColor = ResourcesCompat.getColor(resources,R.color.angleTextColor,null)
    private val lengthTextColor = ResourcesCompat.getColor(resources,R.color.angleTextColor,null)

    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap

    private val plotPaint = Paint().apply {
        color = plotColor
        isAntiAlias = true
        isDither = true
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = strokeWidth
    }

    override fun onSizeChanged(width:Int,height:Int,oldWidth:Int,oldHeight:Int) {
        super.onSizeChanged(width,height,oldWidth,oldHeight)
        if(::extraBitmap.isInitialized) extraBitmap.recycle()
        extraBitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(plotColor)
    }

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)

        canvas.drawRect(10.0F,10.0F,20.0F,20.0F,plotPaint)
    }
}