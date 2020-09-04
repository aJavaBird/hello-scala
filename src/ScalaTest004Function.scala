object ScalaTest004Function {
  def main(args: Array[String]): Unit = {
    var a = addMany(1,2,3,4,5,6,7,8) // 可变参数 函数
    println(a)

    // 函数的 默认参数
    add()
    add(5)
    add(b=8)

    // 部分参数应用函数
    var add12 = add(12,_:Int)  //  等同于 var add12:(Int)=>Int = (x)=>add(12,x)
    add12(13)

  }

  // 定义一个可变参数的方法（入参类型多了一个星号！）
  def addMany(params : Int*): Int ={
    var total:Int = 0
    for(ele<-params){
      total+=ele
    }
    total
  }

  // 默认参数函数
  def add(a: Int=3,b: Int=4): Int = {
    println(s"$a+$b=${a+b}")
    a+b
  }

}
