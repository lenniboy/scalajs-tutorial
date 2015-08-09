package tutorial.webapp

import org.scalajs.dom
import org.scalajs.dom.Event

import scala.scalajs.js.JSApp

object TutorialApp extends JSApp
  with Appending {

  def main(): Unit = {
    dom.document.addEventListener("DOMContentLoaded", { e: Event =>
      println("loaded")
      val output = new UpperCaseOutput()
      val dropDown = new TextInput(textUpdate = output.setOutput)
      val container = new MainContainer(Seq(dropDown, output))
      append(container)
    })
  }
}

trait Appending {
  def append(component: WebComponent): Unit = dom.document.body.appendChild(component.render)
}


