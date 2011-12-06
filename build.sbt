name := "ftest"

version := "1.0"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
  "com.twitter"                   %% "finagle"            % "1.9.11"            intransitive(),
  "com.twitter"                   %% "finagle-core"       % "1.9.11"            withSources(),
  "com.twitter"                   %% "finagle-http"       % "1.9.11"            withSources()
)

resolvers ++= Seq(
  "twttr" at "http://maven.twttr.com"
)

