package threadPool

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.RecursiveTask

class SumTask(
    private val begin: Int,
    private val end: Int,
    private val arr: IntArray
): RecursiveTask<Int>() {
    companion object {
        const val THRESHOLD = 1000
    }

    override fun compute(): Int {
        if (end - begin < THRESHOLD) {
            var sum = 0
            for (i in begin until end) {
                sum += arr[i]
            }
            println(sum)
            return sum
        } else {
            val middle = (begin + end) / 2
            val left = SumTask(begin, middle, arr)
            val right = SumTask(middle, end, arr)
            left.fork()
            right.fork()
            return left.join() + right.join()
        }
    }
}

fun main() {
    val forkJoinPool = ForkJoinPool()
    val arr = IntArray(10000) { it }

    val sumTask = SumTask(0, arr.size, arr)
    val sum = forkJoinPool.invoke(sumTask)
    println(sum)
}