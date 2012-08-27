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


  def main(args: Array[String]) {
    val cli1 = ClientBuilder()
      .codec(Http())
      .hosts("api.dropbox.com:443")
      .tlsWithoutValidation()
      .tcpConnectTimeout(73.milliseconds)
      .hostConnectionLimit(1).build()
    val req1 = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/1/oauth/request_token")
    req1.addHeader("Host", "api.dropbox.com:443")
    val res = cli1(req1).apply()
    println(res)
    cli1.release()
  }

}


