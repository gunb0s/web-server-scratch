import java.io.IOException
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

/**
 * The server creates a ServerSocket that specifies that it will listen to port 6013.
 * The server then begins listening to the port with the accept() method.
 * The server blocks on the accept() method waiting for a client to request a connection.
 * When a connection request is received, accept() returns a socket that the server can use to communicate with the client.
 */

fun main(args: Array<String>) {
    try {
        val sock: ServerSocket = ServerSocket(6013)

        /* now listen for connections */
        while (true) {
            println("Server is listening...")
            val client: Socket = sock.accept()
            println(client)
            val pout: PrintWriter = PrintWriter(client.getOutputStream(), true)

            /* write the Date to the socket */
            pout.println(java.util.Date().toString())

            /* close the socket and resume */
            /* listening for connections */
            client.close()
        }
    } catch (ioe: IOException) {
        System.err.println(ioe)
    }
}