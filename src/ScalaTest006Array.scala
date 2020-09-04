object ScalaTest006Array {
  def main(args: Array[String]): Unit = {
    // 定义一个数组
    val array = Array[Int](2,4,6,9,3)
    // map 方法是将 array 数组中的每个元素进行某种映射操作, (x: Int) => x * 2 为 一个匿名函数, x 就是 array 中的每个元素
    val y = array map((x: Int) => x * 2)
    // 或者这样写, 编译器会自动推测 x 的数据类型
    val z = array.map(x => x*2)
    // 亦或者, _ 表示入参, 表示数组中的每个元素值
    val x = array.map(_ * 2)

    println(x.toBuffer) // 4, 8, 12, 18, 6

    // 使用 new 关键字创建的是一个 空的数组，传入的数字是 数组长度
    val arr1 = new Array[Int](3)
    arr1(0) = 10
    println(arr1.toBuffer) // 10, 0, 0

    val arr2 = Array("hello world hello tom jerry","hi tom hi jerry","hello nice to meet you")

    val arr2_map = arr2.map( _.split(" ") ) // 得到的是一个 Array( Array, Array, Array ) 对象，并不是我们所期待的
    val arr2_mapFlat = arr2.map( _.split(" ") ).flatten // 得到的是 Array(...) 是最终想要的
    val arr2_flatMap = arr2.flatMap( _.split(" "))  // 和上一步得到的一致，为 map + flatten 的合并操作
    println(arr2_flatMap.toBuffer)

    // 实现wordcount
    println("-------------- wordcount start -------------")
    // 统计 arr2 中 各个单词的个数
    var arr2_wordcount = arr2.flatMap( _.split(" ")) /* 使用空格把数组划分为每个单词一个元素 */
        .groupBy(a=>a) /* 分组操作，每个单词到一个组里面，此时得到一个map对象，格式如: hello:[hello,hello],tom:[tom] */
//        .map(x=>x._2.length) /* ._2 表示 第二个元素，此处map的第二个元素为Array对象 */
        .mapValues(x => x.length) /* 功能和上一行一样，不同的是，这里直接取出map的value进行操作，不需要写 ._2 */
        .toList /* toList 是把map转换为list，因为只有list可以排序，map不能排序 */
//        .sortBy(x => x._2) /* 升序排序 */
        .sortBy(x => - x._2) /* 降序排序 */

    println(arr2_wordcount.toBuffer)

    println("-------------- wordcount end -------------")

  }
}
