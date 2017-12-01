name := "reddit_challenges"

version := "1.0"

scalaVersion := "2.12.1"
libraryDependencies ++= Seq(
  "org.apache.kafka" %% "kafka" % "0.10.1.1",
  "com.typesafe.akka" %% "akka-actor" % "2.5.7",
  "com.typesafe.akka" %% "akka-stream" % "2.5.7"

)
        