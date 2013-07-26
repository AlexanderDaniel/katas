name := "equi"

version := "0.1-SNAPSHOT"
 
scalaVersion := "2.10.2"
  
libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.1.1" % "test" // as described at http://etorreborre.github.io/specs2/
)

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

scalacOptions in Test ++= Seq("-Yrangepos") // as described at http://etorreborre.github.io/specs2/

