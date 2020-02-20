package arte921.maffs

import java.lang.Math.PI
import kotlin.math.asin
import kotlin.math.sin

class triangle (a: Double,b: Double,c: Double,alfa: Double,beta: Double,gamma: Double){
    var a: Double = a
    var b: Double = b
    var c: Double = c
    var alfa: Double = alfa
    var beta: Double = beta
    var gamma: Double = gamma
    var calculated: Boolean = true

    fun calculate(){
        calculated = true
        while(calculated){
            calculated = false

            if(a<0){

            }

            if(b<0){

            }

            if(b<0){

            }

            if(alfa<0){
                if(beta >= 0 || gamma >= 0) alfa = PI - beta - gamma; calculated = true

                //sinusregel
                if(a >= 0){
                    if(c >= 0 && beta >= 0){
                        alfa = asin(a*sin(beta)/b)
                        calculated = true
                    }else if(b >= 0 && gamma >= 0){
                        alfa = asin(a*sin(gamma)/c)
                        calculated = true
                    }
                }
                //cosinusregel





            }

            if(beta<0){

            }

            if(gamma<0){

            }
        }

    }
}