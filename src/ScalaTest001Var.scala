object ScalaTest001Var {

  def main(args: Array[String]): Unit = {
    /**
     * 可以使用 var 和 val 修饰变量，其中，var变量是可以重新赋值的，val变量则不行，val变量相当于java中的final变量
     *
     * */

    println("hello scala var test")
    var a:String = "aaa1"; // 可简写为 var a = "aaa1";
    a = "aaa2";

    val b = 12; // 相当于 val b:Int = 12;
    //    b = 13; // 直接编译不过去

    var c = 12.668;

    println(f"a=$a") // 仅仅作参数替换
    printf("a=%s,c=%4.2f\n",a,c) // c 保留2位有效数字输出
    println(f"a=$a%s",s"b=$b") // 使用逗号分割，会把多个入参格式化输出
    println(s"b=$b,问b的两倍是多少？  -->  ${b*2}") // ${} 里面写的是一个表达式

    var ifResult = if(c/2>6) "c的一半大于6" else "c的一半小于6"
    println(ifResult)

    var ifResult2 = if(c>20) {1} // if条件未满足，且没有else 表示 ifResult2 的值 为null，打印出来是 ()
    println(ifResult2)

    var ifResult3 = if(c>20) {
      1
    }else{
      2
      3
    }
    println(ifResult3) // ifResult3 = 3

  }

}
