// @SOURCE:/Users/Martin/Desktop/PlayProject/conf/routes
// @HASH:72b9166a74bf29a15b1173d4c6a8c0e49366eac8
// @DATE:Sun Mar 01 21:44:01 ICT 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_Application_votingresult1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("result"))))
private[this] lazy val controllers_Application_votingresult1_invoker = createInvoker(
controllers.Application.votingresult,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "votingresult", Nil,"GET", """""", Routes.prefix + """result"""))
        

// @LINE:8
private[this] lazy val controllers_Application_gotoVotePage2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("vote"))))
private[this] lazy val controllers_Application_gotoVotePage2_invoker = createInvoker(
controllers.Application.gotoVotePage,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "gotoVotePage", Nil,"GET", """""", Routes.prefix + """vote"""))
        

// @LINE:11
private[this] lazy val controllers_Voting_addVote3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("voting"))))
private[this] lazy val controllers_Voting_addVote3_invoker = createInvoker(
controllers.Voting.addVote,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Voting", "addVote", Nil,"POST", """""", Routes.prefix + """voting"""))
        

// @LINE:14
private[this] lazy val controllers_Assets_at4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at4_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """result""","""controllers.Application.votingresult"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """vote""","""controllers.Application.gotoVotePage"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """voting""","""controllers.Voting.addVote"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
   }
}
        

// @LINE:7
case controllers_Application_votingresult1_route(params) => {
   call { 
        controllers_Application_votingresult1_invoker.call(controllers.Application.votingresult)
   }
}
        

// @LINE:8
case controllers_Application_gotoVotePage2_route(params) => {
   call { 
        controllers_Application_gotoVotePage2_invoker.call(controllers.Application.gotoVotePage)
   }
}
        

// @LINE:11
case controllers_Voting_addVote3_route(params) => {
   call { 
        controllers_Voting_addVote3_invoker.call(controllers.Voting.addVote)
   }
}
        

// @LINE:14
case controllers_Assets_at4_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at4_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     