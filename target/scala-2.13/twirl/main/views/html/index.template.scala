
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/main("Car Manual Api")/*3.24*/ {_display_(Seq[Any](format.raw/*3.26*/("""
  """),format.raw/*4.3*/("""<div class="body-wrapper">
    <div class="block-wrapper block-wrapper-header">
      <h1>Welcome to car manual!</h1>
      <h2>Api directory:&emsp;/api</h2>
    </div>
    <div class="block-wrapper">
      <h3>GET&emsp;/$id</h3>
      <p>get info about car with id = $id</p>
    </div>
    <div class="block-wrapper">
      <h3>GET&emsp;/all</h3>
      <p>get list info of all cars</p>
      <h4>params: number, color, brand, year, orderBy</h4>
      <p>for number, color and brand you can use</p>
      <p>"_" - one unknown char</p>
      <p>"*" - many or no one unknown chars</p>
      <p>year more than 1900 and less then 2022</p>
      <p>order by:<p>
      <p>&emsp;1 - id</p>
      <p>&emsp;2 - number</p>
      <p>&emsp;3 - color</p>
      <p>&emsp;4 - brand</p>
      <p>&emsp;5 - year</p>
    </div>
    <div class="block-wrapper">
      <h3>DELETE&emsp;/$id</h3>
      <p>delete car with id = $id</p>
    </div>
    <div class="block-wrapper">
      <h3>POST&emsp;/add</h3>
      <p>add car info in json format. Example:</p>
      <code>"""),format.raw/*35.13*/("""{"""),format.raw/*35.14*/("""
          """),format.raw/*36.11*/(""""number":"АА123А96",
          "color":"red",
          "brand":"Honda",
          "year":2000
        """),format.raw/*40.9*/("""}"""),format.raw/*40.10*/("""</code>
      <p>Number format: [АВЕКМНОРСТУХ]"""),format.raw/*41.39*/("""{"""),format.raw/*41.40*/("""2"""),format.raw/*41.41*/("""}"""),format.raw/*41.42*/("""\d"""),format.raw/*41.44*/("""{"""),format.raw/*41.45*/("""3"""),format.raw/*41.46*/("""}"""),format.raw/*41.47*/("""[АВЕКМНОРСТУХ]\d"""),format.raw/*41.63*/("""{"""),format.raw/*41.64*/("""2,3"""),format.raw/*41.67*/("""}"""),format.raw/*41.68*/("""</p>
    </div>
    <div class="block-wrapper">
      <h3>GET&emsp;/stat</h3>
      <p>get some statistic</p>
    </div>
    <div class="block-wrapper">
      <h3>GET&emsp;/log</h3>
      <p>print requests to api</p>
    </div>
  </div>
""")))}),format.raw/*52.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 7ad31817f7589cf64a7b14d3fd255e8bd021d195
                  MATRIX: 722->1|818->3|848->8|878->30|917->32|947->36|2054->1115|2083->1116|2123->1128|2257->1235|2286->1236|2361->1283|2390->1284|2419->1285|2448->1286|2478->1288|2507->1289|2536->1290|2565->1291|2609->1307|2638->1308|2669->1311|2698->1312|2977->1561
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|60->35|60->35|61->36|65->40|65->40|66->41|66->41|66->41|66->41|66->41|66->41|66->41|66->41|66->41|66->41|66->41|66->41|77->52
                  -- GENERATED --
              */
          