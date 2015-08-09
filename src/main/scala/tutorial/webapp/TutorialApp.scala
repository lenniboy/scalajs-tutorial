package tutorial.webapp

import org.scalajs.dom
import org.scalajs.dom.Event
import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js.JSApp
import scalatags.JsDom.all._

object TutorialApp extends JSApp
  with Appending {

  def main(): Unit = {
    dom.document.addEventListener("DOMContentLoaded", { e: Event =>
      println("loaded")
      val dropDown = new DropDown(textUpdate = println)
      val container = new MainContainer(Seq(dropDown))
      append(container)
    })
  }
}

trait Appending {
  def append(component: WebComponent): Unit = dom.document.body.appendChild(component.render)
}


