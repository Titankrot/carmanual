// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:10
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:13
  class ReverseApiController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def insertCar(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/add")
    }
  
    // @LINE:13
    def getCar(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/" + implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id))
    }
  
    // @LINE:14
    def getListCars(number:String = "*", color:String = "*", brand:String = "*", year:Long = -1, orderBy:Int = 1): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/all" + play.core.routing.queryString(List(if(number == "*") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("number", number)), if(color == "*") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("color", color)), if(brand == "*") None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("brand", brand)), if(year == -1) None else Some(implicitly[play.api.mvc.QueryStringBindable[Long]].unbind("year", year)), if(orderBy == 1) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("orderBy", orderBy)))))
    }
  
    // @LINE:15
    def deleteCar(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/" + implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id))
    }
  
    // @LINE:18
    def getLog(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/log")
    }
  
    // @LINE:17
    def getStat(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/stat")
    }
  
  }


}
