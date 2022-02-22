package models

import anorm.SqlParser.get
import anorm.{SqlStringInterpolation, ~}
import org.joda.time.DateTime

import javax.inject.Inject
import play.api.db.DBApi

import scala.concurrent.Future

@javax.inject.Singleton
class CarRepository @Inject()(dbapi: DBApi)(implicit databaseExecutionContext: DatabaseExecutionContext) {
  private val db = dbapi.database("default")

  private val car = {
    get[Long]("id") ~
      get[String]("carNumber") ~
      get[String]("carColor") ~
      get[String]("carBrand") ~
      get[Int]("yearOfCreate") map {
      case id~carNumber~carColor~carBrand~yearOfCreate => Car(id, carNumber, carColor, carBrand, yearOfCreate)
    }
  }

  def findById(id: Long): Future[Option[Car]] = Future {
    db.withConnection {implicit connection =>
      SQL"SELECT * FROM CARS WHERE id = $id".as(car.singleOpt)
    }
  }(databaseExecutionContext)

  def list(number: String = "%", color: String = "%", brand: String = "%", year: Long = -1, orderBy: String = "1"): Future[List[Car]] = Future {
    db.withConnection { implicit connection => year match {
      case -1 => SQL"""SELECT * FROM CARS
            WHERE carNumber LIKE ${number}
            AND carColor LIKE ${color}
            AND carBrand LIKE ${brand}
            ORDER BY ${orderBy}""".as(car.*)
      case year => SQL"""SELECT * FROM CARS
            WHERE carNumber LIKE ${number}
            AND carColor LIKE ${color}
            AND carBrand LIKE ${brand}
            AND yearOfCreate = ${year}
            ORDER BY ${orderBy}""".as(car.*)
      }
    }
  }(databaseExecutionContext)

  def insert(car: Car): Future[Option[Long]] = Future {
    db.withConnection { implicit connection =>
      val processStart: DateTime = DateTime.now()
      SQL"""
        INSERT INTO Cars VALUES (
          DEFAULT,
          ${car.carNumber}, ${car.carColor}, ${car.carBrand}, ${car.yearOfCreate}, CURRENT_TIMESTAMP
        )
      """.executeInsert()
    }
  }(databaseExecutionContext)

  def delete(id: Long) = Future {
    db.withConnection { implicit connection =>
      SQL"DELETE FROM Cars WHERE id = $id".executeUpdate()
    }
  }(databaseExecutionContext)

  def getFirstRowTime(): Future[String] = Future {
    db.withConnection { implicit  connection =>
      SQL"""select timeOfRow from Cars
      ORDER BY timeofRow
        limit 1;""".as(get[DateTime]("timeofrow").singleOpt) match {
        case Some(x) => x.toString
        case y => y.toString
      }
    }
  }(databaseExecutionContext)

  def getLastRowTime(): Future[String] = Future {
    db.withConnection { implicit  connection =>
      SQL"""SELECT timeOfRow FROM Cars
      ORDER BY timeofRow DESC
        LIMIT 1;""".as(get[DateTime]("timeofrow").singleOpt) match {
      case Some(x) => x.toString
      case y => y.toString
      }
    }
  }(databaseExecutionContext)

  def getCountOfRows(): Future[String] = Future {
    db.withConnection { implicit  connection =>
      SQL"""SELECT COUNT(*) FROM Cars""".as(get[Long]("count").single.map(_.toString))
    }
  }
}
