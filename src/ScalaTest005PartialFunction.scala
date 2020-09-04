object ScalaTest005PartialFunction {
  def main(args: Array[String]): Unit = {
    /**
     * 偏函数测试
     * */

    println( getInt("two") ) // 偏函数简单应用

    var arr = Array[Any](1,2,3,"你在哪")
    var cole = arr.collect(add10) // 得使用偏函数 到一个对象
//    var cole = arr.collect({case a:Int => a+10}) // 这行代码和上一行代码实现的一样，使用的是匿名的偏函数
    println(cole.toBuffer) // 11、12、13

    var arr2 = Array[Int](1,2,3)
    // 数组的 map 方法中传入一个函数，此函数会对 数组中的每一个元素进行操作
    var arr2_2 = arr2.map( (x:Int)=>{x+1} )
    var arr2_3 = arr2.map( _+1 ) // 和上一行作用一致，算是简写
    println(arr2.toBuffer) // arr2 没有改变，map后会返回一个新的对象，还是 1, 2, 3
    println(arr2_2.toBuffer)  // 2, 3, 4
    println(arr2_3.toBuffer)  // 2, 3, 4

  }

  // 偏函数好像可以看作 case 语句的加强版
  // 中括号里面的两个类型String、Int 分别是偏函数的入参和出参
  def getInt: PartialFunction[String,Int]={
    case "one" => 1
    case "two" => 2
    case _ => 0
  }

  // 偏函数，将传入数字进行加 10 操作（如果传入的不是数字，则没有返回）
  def add10: PartialFunction[Any,Int] = {
    case a:Int => a+10
  }

}
