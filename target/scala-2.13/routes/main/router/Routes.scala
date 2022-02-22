// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_0: controllers.HomeController,
  // @LINE:10
  Assets_1: controllers.Assets,
  // @LINE:13
  ApiController_2: controllers.ApiController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_0: controllers.HomeController,
    // @LINE:10
    Assets_1: controllers.Assets,
    // @LINE:13
    ApiController_2: controllers.ApiController
  ) = this(errorHandler, HomeController_0, Assets_1, ApiController_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, ApiController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/""" + "$" + """id<[0-9]+>""", """controllers.ApiController.getCar(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/all""", """controllers.ApiController.getListCars(number:String ?= "%", color:String ?= "%", brand:String ?= "%", year:Long ?= -1, orderBy:Int ?= 1)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/""" + "$" + """id<[0-9]+>""", """controllers.ApiController.deleteCar(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/add""", """controllers.ApiController.insertCar()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/stat""", """controllers.ApiController.getStat()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/log""", """controllers.ApiController.getLog()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_ApiController_getCar2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/"), DynamicPart("id", """[0-9]+""",false)))
  )
  private[this] lazy val controllers_ApiController_getCar2_invoker = createInvoker(
    ApiController_2.getCar(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "getCar",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """api/""" + "$" + """id<[0-9]+>""",
      """ Api""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_ApiController_getListCars3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/all")))
  )
  private[this] lazy val controllers_ApiController_getListCars3_invoker = createInvoker(
    ApiController_2.getListCars(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Long], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "getListCars",
      Seq(classOf[String], classOf[String], classOf[String], classOf[Long], classOf[Int]),
      "GET",
      this.prefix + """api/all""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_ApiController_deleteCar4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/"), DynamicPart("id", """[0-9]+""",false)))
  )
  private[this] lazy val controllers_ApiController_deleteCar4_invoker = createInvoker(
    ApiController_2.deleteCar(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "deleteCar",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """api/""" + "$" + """id<[0-9]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_ApiController_insertCar5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/add")))
  )
  private[this] lazy val controllers_ApiController_insertCar5_invoker = createInvoker(
    ApiController_2.insertCar(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "insertCar",
      Nil,
      "POST",
      this.prefix + """api/add""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_ApiController_getStat6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/stat")))
  )
  private[this] lazy val controllers_ApiController_getStat6_invoker = createInvoker(
    ApiController_2.getStat(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "getStat",
      Nil,
      "GET",
      this.prefix + """api/stat""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_ApiController_getLog7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/log")))
  )
  private[this] lazy val controllers_ApiController_getLog7_invoker = createInvoker(
    ApiController_2.getLog(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "getLog",
      Nil,
      "GET",
      this.prefix + """api/log""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index())
      }
  
    // @LINE:10
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:13
    case controllers_ApiController_getCar2_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ApiController_getCar2_invoker.call(ApiController_2.getCar(id))
      }
  
    // @LINE:14
    case controllers_ApiController_getListCars3_route(params@_) =>
      call(params.fromQuery[String]("number", Some("%")), params.fromQuery[String]("color", Some("%")), params.fromQuery[String]("brand", Some("%")), params.fromQuery[Long]("year", Some(-1)), params.fromQuery[Int]("orderBy", Some(1))) { (number, color, brand, year, orderBy) =>
        controllers_ApiController_getListCars3_invoker.call(ApiController_2.getListCars(number, color, brand, year, orderBy))
      }
  
    // @LINE:15
    case controllers_ApiController_deleteCar4_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_ApiController_deleteCar4_invoker.call(ApiController_2.deleteCar(id))
      }
  
    // @LINE:16
    case controllers_ApiController_insertCar5_route(params@_) =>
      call { 
        controllers_ApiController_insertCar5_invoker.call(ApiController_2.insertCar())
      }
  
    // @LINE:17
    case controllers_ApiController_getStat6_route(params@_) =>
      call { 
        controllers_ApiController_getStat6_invoker.call(ApiController_2.getStat())
      }
  
    // @LINE:18
    case controllers_ApiController_getLog7_route(params@_) =>
      call { 
        controllers_ApiController_getLog7_invoker.call(ApiController_2.getLog())
      }
  }
}
