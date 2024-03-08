import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.Socket

/**
 * The client creates a Socket and requests a connection with the server at IP address 127.0.0.1 on port 6013.
 * Once the connection is made, the client can read from the socket using normal stream I/O statements.
 * After it has received date from the server, the client closes the socket and exits
 */

fun main(args: Array<String>) {
    try {
        /* make connection to server socket */
        val socket = Socket("127.0.0.1", 6013)

        val inputStream = socket.getInputStream()
        val bin = BufferedReader(InputStreamReader(inputStream))

        /* read the date from the socket */
        var line: String?
        while ((bin.readLine().also { line = it }) != null) {
            println(line)
        }

        /* close the socket connection */
        socket.close()
    } catch(ioe: IOException) {
        System.err.println(ioe)
    }
}