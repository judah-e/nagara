import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "nagara"
    val appVersion      = "1.0-SNAPSHOT"
    val scalaVersion    = "2.10.3"

    val appDependencies = Seq(
      "mysql" % "mysql-connector-java" % "5.1.18",
      jdbc,
      anorm
    )

    lazy val lib = RootProject(file("../lib"))

    val main = play.Project(appName, appVersion, appDependencies
    ).dependsOn(
      lib, common, api, admin, website
    ).aggregate(
      common, api, admin, website
    ) 

    lazy val common = play.Project(
      name = appName + "-common", 
      path = file("modules/common")).settings(
    ).dependsOn(
      lib
    )

    lazy val admin = play.Project(
      name = appName + "-admin",
      path = file("modules/admin")).settings(
    ).dependsOn(
      lib, common
    )

    lazy val api = play.Project(
      name = appName + "-api",
      path = file("modules/api")).settings(
    ).dependsOn(
      lib, common
    )

    lazy val website = play.Project(
      name = appName + "-website",
      path = file("modules/website")).settings(
    ).dependsOn(
      lib, common
    )

}
