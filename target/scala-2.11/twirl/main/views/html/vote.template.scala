
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
object vote extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/mainVote("Vote page")/*3.23*/ {_display_(Seq[Any](format.raw/*3.25*/("""

    """),format.raw/*5.5*/("""<!--"""),_display_(/*5.10*/play20/*5.16*/.welcome(message, style = "Java")),format.raw/*5.49*/("""-->

    <!--<div ui-content-for="title">
        <span>Forms</span>
    </div>-->

    <div id="header">
        <h1>"""),_display_(/*12.14*/message),format.raw/*12.21*/("""</h1>
    </div>

    <form id="score" role="form" action = "/voting" method = post>
        <div class="creativity">
            <label for="sel1">Creativity</label>
            <span class="rating">
                <input type="radio" class="rating-input"
                id="rating-input1-5" name="sel1" value="5">
                <label for="rating-input1-5" class="rating-star"></label>

                <input type="radio" class="rating-input"
                id="rating-input1-4" name="sel1" value="4">
                <label for="rating-input1-4" class="rating-star"></label>

                <input type="radio" class="rating-input"
                id="rating-input1-3" name="sel1" value="3">
                <label for="rating-input1-3" class="rating-star"></label>

                <input type="radio" class="rating-input"
                id="rating-input1-2" name="sel1" value="2">
                <label for="rating-input1-2" class="rating-star"></label>

                <input type="radio" class="rating-input"
                id="rating-input1-1" name="sel1" value="1">
                <label for="rating-input1-1" class="rating-star"></label>
            </span>
        </div>
        <br>
        <br>
        <div class="appearance">
            <label for="sel2">Appearance</label>
            <span class="rating">
                <input type="radio" class="rating-input"
                id="rating-input2-5" name="sel2" value="5">
                <label for="rating-input2-5" class="rating-star"></label>

                <input type="radio" class="rating-input"
                id="rating-input2-4" name="sel2" value="4">
                <label for="rating-input2-4" class="rating-star"></label>

                <input type="radio" class="rating-input"
                id="rating-input2-3" name="sel2" value="3">
                <label for="rating-input2-3" class="rating-star"></label>

                <input type="radio" class="rating-input"
                id="rating-input2-2" name="sel2" value="2">
                <label for="rating-input2-2" class="rating-star"></label>

                <input type="radio" class="rating-input"
                id="rating-input2-1" name="sel2" value="1">
                <label for="rating-input2-1" class="rating-star"></label>
            </span>
        </div>
        <br>
        <br>
        <div class="performance">
            <label for="sel3">Performance</label>
            <span class="rating">
                <input type="radio" class="rating-input"
                id="rating-input3-5" name="sel3" value="5">
                <label for="rating-input3-5" class="rating-star"></label>

                <input type="radio" class="rating-input"
                id="rating-input3-4" name="sel3" value="4">
                <label for="rating-input3-4" class="rating-star"></label>

                <input type="radio" class="rating-input"
                id="rating-input3-3" name="sel3" value="3">
                <label for="rating-input3-3" class="rating-star"></label>

                <input type="radio" class="rating-input"
                id="rating-input3-2" name="sel3" value="2">
                <label for="rating-input3-2" class="rating-star"></label>

                <input type="radio" class="rating-input"
                id="rating-input3-1" name="sel3" value="1">
                <label for="rating-input3-1" class="rating-star"></label>
            </span>
        </div>
        <br>
        <br>

        <button id="submit" type="submit" class="btn btn-primary btn-block center-block">Submit</button>
    </form>
    <div id="browse_app" class="text-center">
        <a class="btn btn-large btn-info" href="/result">Browse to result page (Test)</a>
    </div>
    <br>
    <br>
    <div id="browse_app" class="text-center">
        <a class="btn btn-large btn-info" href="/">Browse to index page (Test)</a>
    </div>


""")))}),format.raw/*107.2*/("""
"""))}
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 01 23:13:15 ICT 2015
                  SOURCE: /Users/thanyaboontovorapan/IdeaProjects/TeamMalee/app/views/vote.scala.html
                  HASH: c8bea7fcd01b2df6b06d9e8b28666da623de94be
                  MATRIX: 722->1|827->18|855->21|884->42|923->44|955->50|986->55|1000->61|1053->94|1199->213|1227->220|5179->4141
                  LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|33->5|40->12|40->12|135->107
                  -- GENERATED --
              */
          