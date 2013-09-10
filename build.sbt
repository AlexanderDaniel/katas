name := "katas"

version := "0.1-SNAPSHOT"
 
scalaVersion := "2.10.2"
  
libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.1.1" % "test", // as described at http://etorreborre.github.io/specs2/
  "org.mockito" % "mockito-all" % "1.9.0" % "test", // as described at http://etorreborre.github.io/specs2/guide/org.specs2.guide.Runners.html#Dependencies
  "org.hamcrest" % "hamcrest-all" % "1.1" % "test" // as described at http://etorreborre.github.io/specs2/guide/org.specs2.guide.Runners.html#Dependencies
 )

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

scalacOptions in Test ++= Seq("-Yrangepos") // as described at http://etorreborre.github.io/specs2/

