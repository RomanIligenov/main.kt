import jetbrains.letsPlot.export.ggsave
import jetbrains.letsPlot.geom.geomPoint
import jetbrains.letsPlot.letsPlot
import kotlin.collections.ArrayList
import kotlin.random.Random
import kotlin.math.*

fun main() {

    val m: Int = 1000 // число испытаний
    val n: Int = 100000 // число точек
    val number: Int = 4 // номер картинки
    var W: ArrayList<Double> = ArrayList(m)
    for (i in 0 until m){
        W.add(probaD4(n,12345 + i ))
    }
    plot (P(m, W), SoftW(m, W), number)
    println (middle(m, W))
}

fun gener (n: Int, seed: Int): ArrayList<Double> { //генерация массива(разный сид - разный массив)
    val gen = Random (seed)
    var x1: ArrayList<Double> = ArrayList(n)
    for (i in 0 until n) {
        x1.add((gen.nextDouble(-1.0, 1.0)))// изменить не от 0, а от -1 до 1
    }
    return x1
}
fun probaD1 (n: Int, seed: Int): Double{ // перебор точек и подсчет тех, что в шаре
    val t1 = gener(n, seed)
    var k: Double = 0.0
    var s: Double = 0.0
    var r: Double = 0.0
    for (i in 0 until n) { // `1..n` is a Range
        r = (t1[i]*t1[i]).pow(0.5)
        if (r < 1){
            k += 1
        }
    }
    n.toDouble()

    s = 2*k/n
    return s
}
fun probaD2 (n: Int, seed: Int): Double{ // перебор точек и подсчет тех, что в шаре
    val t1 = gener(n, seed)
    val t2 = gener(n, seed+1)
    var k: Double = 0.0
    var s: Double = 0.0
    var r: Double = 0.0
    for (i in 0 until n) { // `1..n` is a Range
        r = (t1[i]*t1[i] + t2[i]*t2[i]).pow(0.5)
       if (r < 1){
           k += 1
       }
    }
    n.toDouble()
    s = 4*k/n
    return s
}
fun probaD3 (n: Int, seed: Int): Double{ // перебор точек и подсчет тех, что в шаре
    val t1 = gener(n, seed)
    val t2 = gener(n, seed+1)
    val t3 = gener(n, seed + 2)
    var k: Double = 0.0
    var s: Double = 0.0
    var r: Double = 0.0
    for (i in 0 until n) { // `1..n` is a Range
        r = (t1[i]*t1[i] + t2[i]*t2[i] + t3[i]*t3[i]).pow(0.5)
        if (r < 1){
            k += 1
        }
    }
    n.toDouble()
    s = 8*k/n
    return s
}
fun probaD4 (n: Int, seed: Int): Double{ // перебор точек и подсчет тех, что в шаре
    val t1 = gener(n, seed)
    val t2 = gener(n, seed+1)
    val t3 = gener(n, seed + 2)
    val t4 = gener(n, seed + 3)
    var k: Double = 0.0
    var s: Double = 0.0
    var r: Double = 0.0
    for (i in 0 until n) { // `1..n` is a Range
        r = (t1[i]*t1[i] + t2[i]*t2[i] + t3[i]*t3[i] + t4[i]*t4[i]).pow(0.5)
        if (r < 1){
            k += 1
        }
    }
    n.toDouble()
    s = 16*k/n
    return s
}
fun probaD5 (n: Int, seed: Int): Double{ // перебор точек и подсчет тех, что в шаре
    val t1 = gener(n, seed)
    val t2 = gener(n, seed+1)
    val t3 = gener(n, seed + 2)
    val t4 = gener(n, seed + 3)
    val t5 = gener(n, seed + 4)
    var k: Double = 0.0
    var s: Double = 0.0
    var r: Double = 0.0
    for (i in 0 until n) { // `1..n` is a Range
        r = (t1[i]*t1[i] + t2[i]*t2[i] + t3[i]*t3[i] + t4[i]*t4[i] + t5[i]*t5[i]).pow(0.5)
        if (r < 1){
            k += 1
        }
    }
    n.toDouble()
    s = 32*k/n
    return s
}
fun probaD6 (n: Int, seed: Int): Double{ // перебор точек и подсчет тех, что в шаре
    val t1 = gener(n, seed)
    val t2 = gener(n, seed + 1)
    val t3 = gener(n, seed + 2)
    val t4 = gener(n, seed + 3)
    val t5 = gener(n, seed + 4)
    val t6 = gener(n, seed + 5)
    var k: Double = 0.0
    var s: Double = 0.0
    var r: Double = 0.0
    for (i in 0 until n) { // `1..n` is a Range
        r = (t1[i]*t1[i] + t2[i]*t2[i] + t3[i]*t3[i] + t4[i]*t4[i] + t5[i]*t5[i] + t6[i]*t6[i]).pow(0.5)
        if (r < 1){
            k += 1
        }
    }
    n.toDouble()
    s = 64*k/n
    return s
}
fun probaD7 (n: Int, seed: Int): Double{ // перебор точек и подсчет тех, что в шаре
    val t1 = gener(n, seed)
    val t2 = gener(n, seed + 1)
    val t3 = gener(n, seed + 2)
    val t4 = gener(n, seed + 3)
    val t5 = gener(n, seed + 4)
    val t6 = gener(n, seed + 5)
    val t7 = gener(n, seed + 6)
    var k: Double = 0.0
    var s: Double = 0.0
    var r: Double = 0.0
    for (i in 0 until n) { // `1..n` is a Range
        r = (t1[i]*t1[i] + t2[i]*t2[i] + t3[i]*t3[i] + t4[i]*t4[i] + t5[i]*t5[i] + t6[i]*t6[i] + t7[i]*t7[i]).pow(0.5)
        if (r < 1){
            k += 1
        }
    }
    n.toDouble()
    s = 128*k/n
    return s
}
fun probaD8 (n: Int, seed: Int): Double{ // перебор точек и подсчет тех, что в шаре
    val t1 = gener(n, seed)
    val t2 = gener(n, seed + 1)
    val t3 = gener(n, seed + 2)
    val t4 = gener(n, seed + 3)
    val t5 = gener(n, seed + 4)
    val t6 = gener(n, seed + 5)
    val t7 = gener(n, seed + 6)
    val t8 = gener(n, seed + 7)
    var k: Double = 0.0
    var s: Double = 0.0
    var r: Double = 0.0
    for (i in 0 until n) { // `1..n` is a Range
        r = (t1[i]*t1[i] + t2[i]*t2[i] + t3[i]*t3[i] + t4[i]*t4[i] + t5[i]*t5[i] + t6[i]*t6[i] + t7[i]*t7[i] + t8[i]*t8[i]).pow(0.5)
        if (r < 1){
            k += 1
        }
    }
    n.toDouble()
    s = 256*k/n
    return s
}
fun probaD9 (n: Int, seed: Int): Double{ // перебор точек и подсчет тех, что в шаре
    val t1 = gener(n, seed)
    val t2 = gener(n, seed + 1)
    val t3 = gener(n, seed + 2)
    val t4 = gener(n, seed + 3)
    val t5 = gener(n, seed + 4)
    val t6 = gener(n, seed + 5)
    val t7 = gener(n, seed + 6)
    val t8 = gener(n, seed + 7)
    val t9 = gener(n, seed + 8)
    var k: Double = 0.0
    var s: Double = 0.0
    var r: Double = 0.0
    for (i in 0 until n) { // `1..n` is a Range
        r = (t1[i]*t1[i] + t2[i]*t2[i] + t3[i]*t3[i] + t4[i]*t4[i] + t5[i]*t5[i] + t6[i]*t6[i] + t7[i]*t7[i] + t8[i]*t8[i] + t9[i]*t9[i]).pow(0.5)
        if (r < 1){
            k += 1
        }
    }
    n.toDouble()
    s = 512*k/n
    return s
}
fun probaD10 (n: Int, seed: Int): Double{ // перебор точек и подсчет тех, что в шаре
    val t1 = gener(n, seed)
    val t2 = gener(n, seed + 1)
    val t3 = gener(n, seed + 2)
    val t4 = gener(n, seed + 3)
    val t5 = gener(n, seed + 4)
    val t6 = gener(n, seed + 5)
    val t7 = gener(n, seed + 6)
    val t8 = gener(n, seed + 7)
    val t9 = gener(n, seed + 8)
    val t10 = gener(n, seed + 9)
    var k: Double = 0.0
    var s: Double = 0.0
    var r: Double = 0.0
    for (i in 0 until n) { // `1..n` is a Range
        r = (t1[i]*t1[i] + t2[i]*t2[i] + t3[i]*t3[i] + t4[i]*t4[i] + t5[i]*t5[i] + t6[i]*t6[i] + t7[i]*t7[i] + t8[i]*t8[i] + t9[i]*t9[i] + t10[i]*t10[i]).pow(0.5)
        if (r < 1){
            k += 1
        }
    }

    n.toDouble()
    s = 1024*k/n
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
fun P ( m: Int, W:ArrayList<Double>): ArrayList<Int> { // будем считать сколько вероятность
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

fun plot (P:ArrayList<Int>, Ws:ArrayList<Double>, number:Int){
    val data = mapOf<String, Any>("x" to Ws, "y" to P)
    val fig_1 = letsPlot(data) +
            geomPoint( color = "dark-green"
                , size = 1.0
            ) { x = "x"; y = "y" }
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