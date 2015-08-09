package tutorial.webapp

import org.scalajs.dom
import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js.JSApp
import scalatags.JsDom.all._

object TutorialApp extends JSApp
  with Appending {

  def main(): Unit = {
    val dropDown = new DropDown(textUpdate = println)
    val container = new MainContainer(Seq(dropDown))
    append(container)
  }

}

class MainContainer(children: Seq[WebComponent]) extends WebComponent {

  private val mainContainer = div(`class` := "container")

  override def render: HTMLElement = {
    val container = mainContainer.render
    children.foreach( c => container.appendChild(c.render))
    container
  }

}

trait Appending {
  def append(component: WebComponent): Unit = dom.document.body.appendChild(component.render)
}

