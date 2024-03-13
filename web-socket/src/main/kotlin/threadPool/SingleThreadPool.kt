package threadPool

import java.util.concurrent.*

fun main(args: Array<String>) {
    val upper = args[0].toInt();

    val pool: ExecutorService = Executors.newSingleThreadExecutor()
    val result: Future<Int> = pool.submit<Int> {
        var sum = 0;
        for (i in 1..upper) {
            sum += i;
        }

        sum
    }

    try {
        println("Sum: ${result.get()}")
    } catch (e: InterruptedException) {
    } catch(e: ExecutionException) {
    } finally {
            pool.shutdown()
    }
}