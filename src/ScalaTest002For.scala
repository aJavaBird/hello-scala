object ScalaTest002For {
  def main(args: Array[String]): Unit = {
    val arr = Array(10,20,30,40,50)
    var arr1 = 0 to 5 // 0 to 5 相当于 0.to(5)，左右都是闭区间 ==> (0,1,2,3,4,5)
    var arr2 = 0 until 5 // 左闭右开 ==> (0,1,2,3,4)
    for(i <- 0 to arr.length-1) println(arr(i))
    // 上一行等同于 for(i <- 0 until arr.length) println(arr(i))
    println("---------------")
    // 筛选出20的偶数倍的数
    for(i <- arr; if i%20==0 ) println(i) // if 前面的分号可以省略
    println("---------------")
    // 两层循环，当i!=j 时，输出结果: 12 13 21 23 31 32
    for(i <- 1 to 3;j <- 1 to 3 if i!=j ) println(10*i+j) // if 前面可以加上分号，但是 i 和 j 之间的分号不可省略
    println("---------------")
    // 将for 循环的结果保存到数组中，需要使用 yield 关键字
    var arr3 = for(i <- 1 to 3;j <- 1 to 3 if i!=j ) yield 10*i+j
    println(arr3)
    println("---------------")
    // 运算符的重载
    var a1 = 1+2;
    var a2 = 1.+(2); // 这个计算就是 加法计算，和 1 to 5 == 1.to(5) 是类似的
    println(s"a1=$a1,a2=${a2}")

  }
}
