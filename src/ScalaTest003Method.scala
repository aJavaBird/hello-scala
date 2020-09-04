object ScalaTest003Method {
  def main(args: Array[String]): Unit = {

    testMethod() // 方法函数测试

    testMethod2() // 函数作为入参

  }

  def testMethod():Unit = {

    println("-------- testMethod start -------------")

    var a = add(12,13)
    println(a)

    sayHello()

    // 函数定义方式1
    //    var fun1 = (x:Int,y:Int) => {x+y+0.1}
    var fun1 = (x:Int,y:Int) => x+y+0.1 // 如果只是一个表达式，则可以不用加大括号
    // 函数定义方式2
    var fun2:(Int,Int) => Double = (x,y) => {x+y+0.2}
    // 无返回值函数
    var funSayHi = () => println("hi~")

    println( fun1(1,2) );

    println( fun2(1,2) );

    funSayHi()

    // 方法可转换为函数（感觉方法转换为函数后，意义不大？）
    add _

    println( add(1,2) );

    /**
     * 1.方法不能作为单独的表达式而存在（参数为空的方法除外），而函数可以
     * 2.函数必须要有参数列表，而方法可以没有参数列表
     * */
  }

  def testMethod2():Unit = {

    println("-------- testMethod2 start -------------")

    var funAdd = (x:Int,y:Int)=>{
      var rs = x+y
      println(s"$x + $y = $rs")
      rs
    }

    var rs = add(funAdd(11,4),8) // 函数结果作为入参，还是 int 作为入参
    println(rs)
    rs = add2(funAdd,11,4) // 函数作为入参
    println(rs)

    rs = add3(()=>{println("hello method")},11,4) // 函数作为入参
    println(rs)

    // 函数作为函数的入参
    var funAdd2 = (x:Int,y:Int,f:()=>Unit)=>{
      println(s"$x + $y = ${x+y}")
      f()
      x + y
    }

    funAdd2(12,13,()=>{println("hi funAdd2~")})

  }

  // 方法的定义必须 以 def 开头，格式为：def methodName ([list of parameters]) : [return type] = {}
  def add(a:Int,b:Int):Int = {
    return a+b; // 可以省略 return 这个单词
  }

  // 第1个入参是函数类型，第2和第3个入参是Int类型
  def add2(f:(Int,Int)=>Int,a:Int,b:Int):Int = {
    f(a,b);
  }

  def add3(f:()=>Unit,a:Int,b:Int):Int = {
    f()
    a+b
  }

  def sayHello() = {
    println("hello")
  }


}
