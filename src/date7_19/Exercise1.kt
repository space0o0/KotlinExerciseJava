package date7_19

fun main(args: Array<String>) {
    println("hello")

    var e1 = Exercise1()
//    e1.f3(arrayOf("wang", "space"))

    var e2 = Exercise2()
//    e2.f3(arrayOf("1", "2", "3"))
//    e2.case(1)

    val pair = Pair("one", "two")
    val (num1, num2) = pair
//    println("we got $num1,$num2")

    val e3 = Exercise3()
    e3.f4()
}

class Exercise1 {

    //Reading a name from the command line
    fun f1(names: Array<String>) {
        if (names.isEmpty()) {
            println("Please provide a name as a command-line argument")
            return
        } else {
            println("hello : ${names[0]}")
        }
    }

    fun f2(names: Array<String>) {
        for (name in names) {
            println(name)
        }
    }

    fun f3(names: Array<String>) {
        val name = if (names.isNotEmpty()) names[0] else "zzz"
        print(when (name) {
            "wang" -> "www"
            "space" -> "sss"
            else -> "not found $name !"
        })
    }

}

class Exercise2 {
    /**
     * get max
     */
    fun f1(int1: Int, int2: Int) {
        print(if (int1 > int2) int1 else int2)
    }

    fun f2(str: String) {
        try {
            println(str.toInt())
        } catch (e: NumberFormatException) {
            println("$str 转换失败")
        }
    }

    fun getStringLength(obj: Any) {
        if (obj is String) {
            println(obj.length)
        } else {
            println(null)
        }
    }

    fun f3(names: Array<String>) {
        for (i in names.indices) {
            println(names[i])
        }
    }

    fun f4() {
        val y = 10
        for (x in 1 until y) {
            println(x)
        }
    }

    fun case(obj: Any) {
        when (obj) {
            is Long -> println("is Long")
            1 -> println("one")
            is Int -> println("is Int")
            "2" -> println("$obj is String")
        }
    }
}

class Pair<K, V>(val first: K, val second: V) {
    operator fun component1(): K {
        return first
    }

    operator fun component2(): V {
        return second
    }
}

data class User(val name: String, val age: Int)

class Exercise3 {
    fun f1() {
        var user = User("john", 19)
        println("my name is ${user.name} , I'm ${user.age} years old")
    }

    fun f2() {
        var fruit = Fruit.Builder().color("yellow").build()
        println("fruit's color is ${fruit.color}")
    }

    fun f3() {
        val map = hashMapOf<Int, String>()
        map.put(1, "one")
        map.put(2, "two")

        for ((key, value) in map) {
            println("$key is $value")
        }
    }

    fun f4() {
        val user = User("mike", 90)
        println(user)

        println(user.copy(name = "jhon"))

    }
}

/**
 * builder模式
 */
class Fruit constructor(builder: Builder) {
    var color: String = ""

    init {
        this.color = builder.color
    }

    class Builder {
        var color: String = ""

        fun color(value: String): Builder {
            this.color = value
            return this
        }

        fun build(): Fruit {
            return Fruit(this)
        }
    }

}