import sbt._
import org.apache.ivy.util.url.CredentialsStore

object InfraBuild extends Build {
  lazy val project = Project("default", file("."))
}
