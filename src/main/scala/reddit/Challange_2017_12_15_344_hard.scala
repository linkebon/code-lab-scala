package reddit

import java.io.PrintWriter
import java.net.Socket
import util.ExecutionTimeHelper
import scala.io.BufferedSource
import scala.util.matching.Regex

/**
  * Today's challenge is simple: write a web client from scratch.
  *
  * Requirements:
  *
  *- Given an HTTP URL (no need to support TLS or HTTPS), fetch the content using a GET request
  *- Display the content on the console (a'la curl)
  *- Exit
  * *
  * For the challenge, your requirements are similar to the HTTP server challenge - implement a thing you use often from scratch instead of using your language's built in functionality:
  * *
  *- You may not use any of your language's built in web client functionality or any third party library or tool. E.g. you can't use Python's urllib, httplib, or a third-party module like requests or curl. Same for any other language and their built in features; you may also not shell out to something like curl (e.g. no system("curl %s", url)).
  *- Your program should use string processing calls to dissect the URL (again, you cannot use any of the built in functionality like Python's urlparse module or Java's java.net.URL, or third-party URL parsing libraries like HTParse).
  *- Your program should support non-standard ports (for instance http://server.io:8080/).
  *- Your program does NOT need to support TLS or SSL.
  *- Your program should use low level socket() calls (or equivalent) to connect to the server, and make a well-formatted HTTP/1.1 request. That's the whole point of the challenge!
  * *
  * A good test server is httpbin, which can give you all sorts of feedback about your client's behavior; another is requestb.in.
  */
object Challange_2017_12_15_344_hard extends App with ExecutionTimeHelper {
  time {
    case class Url(host: String, port: Int)

    def parseUrl(s: String): Url = {
      val regex: Regex ="""(http:\/\/)([a-zA-Z\.]*)(:[0-9]*)?""".r
      s match {
        case regex(_, host, null) => Url(host, 80)
        case regex(_, host, port) => Url(host, port.toInt)
        case _ => throw new Exception("Could not handle url..")
      }
    }

    def get(url: Url): Unit = {
      val socket = new Socket(url.host, url.port)
      //val inputStream: Iterator[String] = new BufferedSource(socket.getInputStream).getLines()
      val bs = new BufferedSource(socket.getInputStream)
      val o = new PrintWriter(socket.getOutputStream)
      o.print(s"GET / HTTP/1.1\r\n")
      o.print(s"Host: ${url.host}\r\n\r\n")
      o.flush()
      for(line <- bs.getLines()) println(line)
      bs.close()
      o.close()
      socket.close()
    }

    val url = "http://httpbin.org"
    get(parseUrl(url))
  }
}
