
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("Vote page")/*3.19*/ {_display_(Seq[Any](format.raw/*3.21*/("""

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
            <select class="form-control" id="sel1" name="sel1">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
        </div>
        <br>
        <br>
        <div class="appearance">
            <label for="sel2">Appearance</label>
            <select class="form-control" id="sel2" name="sel2">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
        </div>
        <br>
        <br>
        <div class="performance">
            <label for="sel3">Performance</label>
            <select class="form-control" id="sel3" name="sel3">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
        </div>
        <br>
        <br>

        <button id="submit" type="submit" class="btn btn-primary btn-block center-block">Submit</button>

        <div class="detailBox">
            <div class="titleBox">
                <label>Comment Box</label>
            </div>
            <div class="commentBox">
                <form class="form-inline" role="form">
                    <div class="form-group">
                        <input class="form-control" type="text" placeholder="Your comments"/>
                    </div>
                </form>
            </div>
        </div>

    </form>
    <div id="browse_app" class="text-center">
        <a class="btn btn-large btn-info" href="/result">Browse to result page (Test)</a>
    </div>
    <br>
    <br>
    <div id="browse_app" class="text-center">
        <a class="btn btn-large btn-info" href="/vote">Vote page</a>
    </div>

    <span class="rating">
        <input type="radio" class="rating-input"
            id="rating-input5" name="rating-input-1" value="5">
        <label for="rating-input5" class="rating-star"></label>

        <input type="radio" class="rating-input"
            id="rating-input4" name="rating-input-1" value="4">
        <label for="rating-input4" class="rating-star"></label>

        <input type="radio" class="rating-input"
            id="rating-input3" name="rating-input-1" value="3">
        <label for="rating-input3" class="rating-star"></label>

        <input type="radio" class="rating-input"
            id="rating-input2" name="rating-input-1" value="2">
        <label for="rating-input2" class="rating-star"></label>

        <input type="radio" class="rating-input"
            id="rating-input1" name="rating-input-1" value="1">
        <label for="rating-input1" class="rating-star"></label>
    </span>
""")))}),format.raw/*99.2*/("""
"""))}
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 01 20:32:44 ICT 2015
                  SOURCE: /Users/Martin/Desktop/PlayProject/app/views/index.scala.html
                  HASH: 640bdd3df145f6b58586ac291d6b50823b0b347a
                  MATRIX: 723->1|828->18|856->21|881->38|920->40|952->46|983->51|997->57|1050->90|1196->209|1224->216|4278->3240
                  LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|33->5|40->12|40->12|127->99
                  -- GENERATED --
              */
          