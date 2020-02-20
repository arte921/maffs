package arte921.maffs

import android.util.Log
import java.lang.Math.PI
import kotlin.math.*

class triangle (a: Double,b: Double,c: Double,alfa: Double,beta: Double,gamma: Double){
    var a: Double = a
    var b: Double = b
    var c: Double = c
    var alfa: Double = alfa
    var beta: Double = beta
    var gamma: Double = gamma
    private var calculated: Boolean = true

    fun calculate(){
        calculated = true
        while(calculated){
            calculated = false

            //Log.i("startsloop"," a: " + a.toString() + " b: " + b.toString() + " c: " + c.toString() + " alfa: " + alfa.toString() + " beta: " + beta.toString() + " gamma: " + gamma.toString())
            if(a<0){
                //sinusregel
                if(alfa >= 0 && beta >= 0 && b >= 0){
                    a = b * sin(alfa) / sin(beta)
                }
                calculated = true
                if(alfa >= 0 && gamma >= 0 && c >= 0){
                    a = c * sin(alfa) / sin(gamma)
                    calculated = true
                }

                //cosinusregel
                if(b >= 0 && c >= 0 && alfa > 0){
                    a = sqrt(b.pow(2)+c.pow(2)-2*b*c*cos(alfa))
                    calculated = true
                }
            }

            if(b<0){
                //sinusregel
                if(beta >= 0 && alfa >= 0 && a >= 0){
                    b = a * sin(beta) / sin(alfa)
                    calculated = true
                }
                if(beta >= 0 && gamma >= 0 && c >= 0){
                    b = c * sin(beta) / sin(gamma)
                    calculated = true
                }

                //cosinusregel
                if(a >= 0 && c >= 0 && beta > 0){
                    b = sqrt(a.pow(2)+c.pow(2)-2*a*c*cos(beta))
                    calculated = true
                }
            }

            if(c<0){
                //sinusregel
                if(gamma >= 0 && alfa >= 0 && a >= 0){
                    c = a * sin(gamma) / sin(alfa)
                    calculated = true
                }
                if(gamma >= 0 && beta >= 0 && b >= 0){
                    c = b * sin(gamma) / sin(beta)
                    calculated = true
                }

                //cosinusregel
                if(a >= 0 && b >= 0 && gamma > 0){
                    c = sqrt(a.pow(2)+b.pow(2)-2*a*b*cos(gamma))
                    calculated = true
                }
            }
            //Log.i("postzijden"," a: " + a.toString() + " b: " + b.toString() + " c: " + c.toString() + " alfa: " + alfa.toString() + " beta: " + beta.toString() + " gamma: " + gamma.toString())

            if(alfa<0){
                if(beta >= 0 || gamma >= 0){
                    alfa = PI - beta - gamma
                    calculated = true
                }

                //sinusregel
                if(a >= 0){
                    if(c >= 0 && beta >= 0){
                        alfa = asin(a*sin(beta)/b)
                        calculated = true
                    }else if(b >= 0 && gamma >= 0){
                        alfa = asin(a*sin(gamma)/c)
                        calculated = true
                    }
                    //Log.i("sinusregel"," a: " + a.toString() + " b: " + b.toString() + " c: " + c.toString() + " alfa: " + alfa.toString() + " beta: " + beta.toString() + " gamma: " + gamma.toString())
                }
                //cosinusregel
                if(a >= 0 && b >= 0 && c >= 0){
                    alfa = acos((b.pow(2)+c.pow(2)-a.pow(2))/(2*b*c))
                    calculated = true
                    //Log.i("cosinusregel"," a: " + a.toString() + " b: " + b.toString() + " c: " + c.toString() + " alfa: " + alfa.toString() + " beta: " + beta.toString() + " gamma: " + gamma.toString())
                }
            }
            //Log.i("postalfa"," a: " + a.toString() + " b: " + b.toString() + " c: " + c.toString() + " alfa: " + alfa.toString() + " beta: " + beta.toString() + " gamma: " + gamma.toString())

            if(beta<0){
                if(alfa >= 0 || gamma >= 0){
                    beta = PI - alfa - gamma
                    calculated = true
                }

                //sinusregel
                if(b >= 0){
                    if(c >= 0 && alfa >= 0){
                        beta = asin(b*sin(alfa)/a)
                        calculated = true
                    }else if(a >= 0 && gamma >= 0){
                        beta = asin(b*sin(gamma)/c)
                        calculated = true
                    }
                }
                //cosinusregel

                if(b >= 0 && a >= 0 && c >= 0){
                    beta = acos((a.pow(2)+c.pow(2)-b.pow(2))/(2*a*c))
                    calculated = true
                }
            }
            //Log.i("postbeta"," a: " + a.toString() + " b: " + b.toString() + " c: " + c.toString() + " alfa: " + alfa.toString() + " beta: " + beta.toString() + " gamma: " + gamma.toString())

            if(gamma<0){
                if(alfa >= 0 || beta >= 0){
                    gamma = PI - alfa - beta
                    calculated = true
                }

                //sinusregel
                if(c >= 0){
                    if(b >= 0 && alfa >= 0){
                        gamma = asin(c*sin(alfa)/a)
                        calculated = true
                    }else if(a >= 0 && beta >= 0){
                        gamma = asin(c*sin(beta)/b)
                        calculated = true
                    }
                }
                //cosinusregel

                if(c >= 0 && a >= 0 && b >= 0){
                    gamma = acos((a.pow(2)+b.pow(2)-c.pow(2))/(2*a*b))
                    calculated = true
                }
            }
            //Log.i("postgamma"," a: " + a.toString() + " b: " + b.toString() + " c: " + c.toString() + " alfa: " + alfa.toString() + " beta: " + beta.toString() + " gamma: " + gamma.toString())

        }

    }
}