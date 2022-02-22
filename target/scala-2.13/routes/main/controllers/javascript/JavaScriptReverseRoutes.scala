// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseApiController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def insertCar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiController.insertCar",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/add"})
        }
      """
    )
  
    // @LINE:13
    def getCar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiController.getCar",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/" + (""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
    // @LINE:14
    def getListCars: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiController.getListCars",
      """
        function(number0,color1,brand2,year3,orderBy4) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/all" + _qS([(number0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("number", number0)), (color1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("color", color1)), (brand2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("brand", brand2)), (year3 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Long]].javascriptUnbind + """)("year", year3)), (orderBy4 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("orderBy", orderBy4))])})
        }
      """
    )
  
    // @LINE:15
    def deleteCar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiController.deleteCar",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/" + (""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
    // @LINE:18
    def getLog: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiController.getLog",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/log"})
        }
      """
    )
  
    // @LINE:17
    def getStat: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiController.getStat",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/stat"})
        }
      """
    )
  
  }


}
