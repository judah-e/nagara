import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "nagara"
    val appVersion      = "1.0-SNAPSHOT"
    val scalaVersion    = "2.10.3"

    val adminDeps = Seq(
      "jp.t2v" %% "stackable-controller" % "0.3.0",
      "mysql" % "mysql-connector-java" % "5.1.18",
      jdbc,
      anorm
    )

    val mainDeps = Seq()
  
    lazy val common = play.Project(appName + "-common", appVersion, adminDeps, path = file("modules/common"))
    lazy val admin = play.Project(appName + "-admin", appVersion, adminDeps, path = file("modules/admin")).settings(
    ).dependsOn(
      common
    ).aggregate(
      common
    )
    lazy val api = play.Project(appName + "-api", appVersion, adminDeps, path = file("modules/api")).settings(
    ).dependsOn(
      common
    ).aggregate(
      common
    )
    lazy val website = play.Project(appName + "-website", appVersion, adminDeps, path = file("modules/website")).settings(
    ).dependsOn(
      common
    ).aggregate(
      common
    )

    lazy  val main = play.Project(appName, appVersion, mainDeps).settings(
      // Add your own project settings here      
    ).dependsOn(admin, api, website).aggregate(admin, api, website)

}
