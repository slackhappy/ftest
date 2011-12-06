import com.twitter.conversions.time._
import com.twitter.conversions.storage._
import com.twitter.finagle.builder._
import com.twitter.finagle.{Service,  SimpleFilter, TimeoutException}
import org.jboss.netty.handler.codec.http._
import org.jboss.netty.handler.codec.http.HttpResponseStatus._
import java.net._
import com.twitter.finagle.http.Http
import com.twitter.util.{Duration, Future} 
import scala.collection.JavaConversions._

object FinagleHttpTestHelper {
  def serverResponse: HttpResponse = {
    var res = new DefaultHttpResponse(HttpVersion.HTTP_1_1, OK)
    res
  }

  val service: Service[HttpRequest, HttpResponse] = new Service[HttpRequest, HttpResponse] { 
    def apply(request: HttpRequest) = {
      try {
        println("received")
      } catch {
        case e => 
          println("server badness " + e)
          throw e
      }
      val res = Future(serverResponse)
      res
    }
  }

  val address: SocketAddress = new InetSocketAddress("localhost", 10000)                                  


  def main(args: Array[String]) {
    val server = ServerBuilder()                            
    .codec(Http())
    .bindTo(address)
    .name("HttpServer")
    .build(service)

    val cli1 = ClientBuilder().codec(Http()).hosts(address).hostConnectionLimit(1).build()
    val req1 = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/test")
    cli1(req1).apply()
    println("done")
  }

}


