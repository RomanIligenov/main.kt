import jetbrains.letsPlot.export.ggsave
import jetbrains.letsPlot.geom.geomLine
import jetbrains.letsPlot.geom.geomPoint
import jetbrains.letsPlot.letsPlot
import kotlin.collections.ArrayList
import kotlin.random.Random
import kotlin.math.*

fun main() {

    val V2:Double = 3.14159265
    task1() // строим V(D)
    task2(V2) // показываем что сигма для D = 2 обратно пропорционально корню из числа точек
}

fun task1 ():Double{
    val m: Int = 1000 // число испытаний
    val n: Int = 100000 // число точек
    var V: ArrayList<Double> = ArrayList(10)
    var D: ArrayList<Double> = ArrayList(10)
    for (j in 1 until 11) {
        var W: ArrayList<Double> = ArrayList(m)
        for (i in 0 until m) {
            W.add(probaD10(n, seed(i), j))
        }
        V.add(middle(m, W))
        D.add(j.toDouble())
    }
    plot(D, V, 77)
    return V[2] // вернем среднее для D = 2
}
fun task2 (V2:Double){
    var n:Int = 100
    val m:Int = 1000
    var sigma: ArrayList<Double> = ArrayList(10) // сигма
    var N: ArrayList<Double> = ArrayList(10) // количество точек
    for (i in 0 until n){
            var W: ArrayList<Double> = ArrayList(m)
            for (j in 0 until m) {
                W.add((probaD10((i+1)*n, seed(j), 2)-V2).pow(2.0))
            }
            sigma.add(middle(m,W).pow(0.5))
            N.add((n*i).toDouble())
    }

    plot(N,sigma,88)
}
fun gener (n: Int, seed: Int): ArrayList<Double> { //генерация массива(разный сид - разный массив)
    val gen = Random (seed)
    var x1: ArrayList<Double> = ArrayList(n)
    for (i in 0 until n) {
        x1.add((gen.nextDouble(-1.0, 1.0)))//  от -1 до 1
    }
    return x1
}


fun seed (i:Int):  ArrayList<Int> {
    val g = Random (i)
    val se:ArrayList<Int> = ArrayList(10)
    for (i in 0 until 10) {
        se.add((g.nextInt()))
    }
    return se
}

fun probaD10 (n: Int, se: ArrayList<Int>, D:Int): Double{ // перебор точек и подсчет тех, что в шаре
    val t1 = gener(n, se[0])
    val t2 = gener(n, se[1])
    val t3 = gener(n, se[2])
    val t4 = gener(n, se[3])
    val t5 = gener(n, se[4])
    val t6 = gener(n, se[5])
    val t7 = gener(n, se[6])
    val t8 = gener(n, se[7])
    val t9 = gener(n, se[8])
    val t10 = gener(n, se[9])
    var k: Double = 0.0
    var s: Double = 0.0
    var r: Double = 0.0
    var d:ArrayList<Int> = ArrayList(10)
    for (i in 0 until D){
        d.add(1)
    }
    if (D<10){
        for (i in D until 10){
            d.add(0)
        }
    }
    for (i in 0 until n) { // `1..n` is a Range
        r = (t1[i]*t1[i]*d[0] + t2[i]*t2[i]*d[1] + t3[i]*t3[i]*d[2] + t4[i]*t4[i]*d[3] + d[4]*t5[i]*t5[i] + d[5]*t6[i]*t6[i] + d[6]*t7[i]*t7[i] + d[7]*t8[i]*t8[i] + d[8]*t9[i]*t9[i] + d[9]*t10[i]*t10[i]).pow(0.5)
        if (r < 1){
            k += 1
        }
    }

    n.toDouble()
    s = 2.0.pow(D)*k/n
    return s
}

fun SoftW (m:Int, W:ArrayList<Double>):ArrayList<Double> { // сортировка полученных объемов
    var W_soft: ArrayList<Double> = ArrayList(m)
    for (i in 0 until m){ // копирование массива ( = работает как ссылка)
        W_soft.add(W[i])
    }
    var k:Int = 0
    var i:Int =0
    var j:Int =0
    while (j < (m-k) ){
        i = j +1
        while (i < (m-k)){
            if (W_soft[j] == W_soft[i]){
                W_soft.removeAt(j)
                k += 1
            }
            i +=1
        }
        j += 1
    }
    return W_soft
}
fun P ( m: Int, W:ArrayList<Double>): ArrayList<Int> { /*будем считать сколько вероятность
                                      Думал сначала использовать вероятности, но через среднее арифметическое
                                      тоже все хорошо*/
    var W_soft: ArrayList<Double> = SoftW(m, W)
    val l: Int = W_soft.size
    var Pv: ArrayList<Int> = ArrayList(l)
    for (i in 0 until l) {
        Pv.add(0)
        for (j in 0 until m) {
            if (W_soft[i] == W[j]) {
                Pv[i] += 1
            }
        }
    }
    return Pv
}

fun plot (X:ArrayList<Double>, Y:ArrayList<Double>, number:Int){
    val data = mapOf<String, Any>("x" to X, "y" to Y)
    val fig_1 = letsPlot(data) +
            geomPoint( color = "dark-green"
                , size = 1.0
            ) + geomLine(color = "dark-green") { x = "x"; y = "y" }
    ggsave(fig_1, "plot_$number.png")
}

fun middle (m:Int, W:ArrayList<Double>): Double {
    var summa: Double = 0.0
    for ( i in 0 until m){
        summa += W[i]
    }
    m.toDouble()
    summa /= m
    return summa
}