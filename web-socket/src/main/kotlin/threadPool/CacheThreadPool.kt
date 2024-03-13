package threadPool

import java.util.concurrent.*;

fun main(args: Array<String>) {
    val numTasks = args[0].trim().toInt()

    /* Create the thread pool */
    val pool = Executors.newCachedThreadPool()

    /* Run each task using a thread in the pool */
    for (i in 0 until numTasks) {
        pool.execute {
            val threadName = Thread.currentThread().name
            println("Task $i is running on thread $threadName")
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }

    pool.shutdown()
}