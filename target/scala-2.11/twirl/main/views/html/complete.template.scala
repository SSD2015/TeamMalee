
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object complete extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[result.Vote],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(votes: List[result.Vote]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.28*/("""

"""),_display_(/*3.2*/main("Vote result")/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
    """),format.raw/*4.5*/("""<div class="text-center">
        """),_display_(/*5.10*/votes/*5.15*/.map/*5.19*/ { vote =>_display_(Seq[Any](format.raw/*5.29*/(""" """),format.raw/*5.30*/("""ID = """),_display_(/*5.36*/vote/*5.40*/.id),format.raw/*5.43*/(""" """),format.raw/*5.44*/("""<br>
        """),_display_(/*6.10*/vote/*6.14*/.sel1),format.raw/*6.19*/(""" """),format.raw/*6.20*/("""<br>
        """),_display_(/*7.10*/vote/*7.14*/.sel2),format.raw/*7.19*/(""" """),format.raw/*7.20*/("""<br>
        """),_display_(/*8.10*/vote/*8.14*/.sel3),format.raw/*8.19*/(""" """),format.raw/*8.20*/("""<br>
        <br>
    """)))}),format.raw/*10.6*/("""
    """),format.raw/*11.5*/("""</div>
    <div id="browse_app" class="text-center">
        <a class="btn btn-large btn-info" href="/">Browse to index page (Test)</a>
    </div>
""")))}))}
  }

  def render(votes:List[result.Vote]): play.twirl.api.HtmlFormat.Appendable = apply(votes)

  def f:((List[result.Vote]) => play.twirl.api.HtmlFormat.Appendable) = (votes) => apply(votes)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 01 18:06:12 ICT 2015
                  SOURCE: /Users/Martin/Desktop/PlayProject/app/views/complete.scala.html
                  HASH: 78fafafbdf21c53955049a44a5c330f9d88d7295
                  MATRIX: 737->1|851->27|879->30|906->49|945->51|976->56|1037->91|1050->96|1062->100|1109->110|1137->111|1169->117|1181->121|1204->124|1232->125|1272->139|1284->143|1309->148|1337->149|1377->163|1389->167|1414->172|1442->173|1482->187|1494->191|1519->196|1547->197|1600->220|1632->225
                  LINES: 26->1|29->1|31->3|31->3|31->3|32->4|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|34->6|34->6|34->6|34->6|35->7|35->7|35->7|35->7|36->8|36->8|36->8|36->8|38->10|39->11
                  -- GENERATED --
              */
          