name := "ftest"

version := "1.0"

scalaVersion := "2.9.2"

libraryDependencies ++= Seq(
  //"com.twitter"                   % "finagle-core_2.9.1"       % "1.9.12"            withSources(),
  //"com.twitter"                   % "finagle-http_2.9.1"       % "1.9.12"            withSources()
  "com.twitter"                   % "finagle-core"       % "5.3.6"            withSources(),
  "com.twitter"                   % "finagle-http"       % "5.3.6"            withSources()
)

resolvers ++= Seq(
  "twttr" at "http://maven.twttr.com/"
)

