package utils


import models.Car
import play.api.libs.json.{JsPath, Json, Reads, Writes}
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

import java.io.{BufferedReader, FileReader, FileWriter}


object utils {
  val NumberRegex = """([АВЕКМНОРСТУХ]{2}\d{3}[АВЕКМНОРСТУХ]\d{2,3})""".r
  val apiLogFilename = "logs/api.log"

  implicit val CarWrites = new Writes[Car] {
    def writes(car: Car) = Json.obj(
      "id" -> car.id,
      "number" -> car.carNumber,
      "color" -> car.carColor,
      "brand" -> car.carBrand,
      "year" -> car.yearOfCreate
    )
  }

  implicit val CarReads: Reads[Car] = (
    (JsPath \ "number").read[String](minLength[String](8) keepAnd maxLength[String](9) ) and
      (JsPath \ "color").read[String](maxLength[String](50)) and
      (JsPath \ "brand").read[String](maxLength[String](50)) and
      (JsPath \ "year").read[Int](min[Int](1900) keepAnd max[Int](2022))
    )(Car.apply(id=0, _, _, _, _))

  def printInApiLog(str: String): Unit = {
    val fw = new FileWriter(apiLogFilename, true)
    fw.write(str + "\n")
    fw.close()
  }

  def replaceSpecialSymbols(str: String): String = str.map { case '*' => '%' case x => x}

  def haveBadSymbols(color: String, brand: String): Boolean = {
    val badSymbols = List('*', '_', '%')
    color.exists(badSymbols.contains) || brand.exists(badSymbols.contains)
  }

  def readApiLog(): String = {
    val fileReader = new BufferedReader(new FileReader(apiLogFilename))
    val buffer = new StringBuilder()
    def handleRead(line : String) : Unit = {
      buffer ++= line ++ "\n"
      val newLine = fileReader.readLine()
      if(newLine != null)
        handleRead(newLine)
    }
    handleRead(fileReader.readLine())
    fileReader.close()
    buffer.toString
  }
}
