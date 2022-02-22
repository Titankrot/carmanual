package controllers


import javax.inject._
import play.api.mvc._
import play.api.libs.json._

import models.{Car, CarRepository}
import utils.utils._

import scala.concurrent.{ExecutionContext, Future}


@Singleton
class ApiController @Inject()(CarService: CarRepository, val controllerComponents: ControllerComponents)(implicit ec: ExecutionContext) extends BaseController {
  def getLog() = Action.async {
    implicit request: Request[AnyContent] => Future(Ok(readApiLog()))
  }

  def getCar(id: Long) = Action.async {
    implicit request: Request[AnyContent] =>
      printInApiLog(s"GET /api/${id}")
      CarService.findById(id).flatMap {
      case Some(car) => Future.successful(Ok(Json.toJson(car)))
      case _ => Future.successful(NotFound("NotFound"))
    }
  }

  def getListCars(number: String, color: String, brand: String, year: Long, orderBy: Int) = Action.async {
    implicit request: Request[AnyContent] =>
      printInApiLog(s"GET /api/all?number=${number}&color=${color}&brand=${brand}&year=${year}&orderBy=${orderBy}")
      CarService.list(number, color, brand, year, orderBy.toString)
        .flatMap(x => Future.successful(Ok(Json.toJson(x))))
  }

  def deleteCar(id: Long) = Action.async {
    implicit request: Request[AnyContent] =>
      printInApiLog(s"DELETE /api/${id}")
      CarService.findById(id).flatMap {
      case Some(Car@car) =>
        CarService.delete(id)
        Future.successful(Ok("Deleted"))
      case _ => Future.successful(NotFound("NotFound"))
    }
  }

  def insertCar() = Action.async {
    implicit request: Request[AnyContent] =>
      val json = request.body.asJson.get
      printInApiLog(s"POST /api/add " + json.toString)
      json.validate[Car] match {
      case JsSuccess(car, _) => car.carNumber match {
        case NumberRegex(carNumber) => CarService.list(number = carNumber).flatMap {
          case Nil =>
            CarService.insert(car)
            Future.successful(Ok("Inserted"))
          case _ => Future.successful(BadRequest("AlreadyHere"))
        }
        case _ => Future.successful(ExpectationFailed("BadNumber"))
      }
      case _ => Future.successful(BadRequest("BadData"))
    }
  }

  def getStat() = Action.async {
    implicit request: Request[AnyContent] =>
      printInApiLog("GET /api/stat")
      val first = "First row time: "
      val second = "Last row time: "
      val third = "Count of rows: "

      val f1 = CarService.getFirstRowTime()
      val f2 = CarService.getLastRowTime()
      val f3 = CarService.getCountOfRows()

      (for {
          a <- f1
          b <- f2
          c <- f3
        } yield Json.obj(
        first -> a,
        second -> b,
        third -> c)).map(x => Ok(x))
  }
}
