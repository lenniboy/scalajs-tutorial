package tutorial.webapp

import org.scalajs.dom
import org.scalajs.dom.raw.{HTMLElement, KeyboardEvent}
import org.scalajs.jquery.jQuery

import scala.scalajs.js.JSApp
import scalatags.JsDom.TypedTag
import scalatags.JsDom.all._


object TutorialApp extends JSApp
  with Appending {

  def main(): Unit = {
    jQuery(setupUI _)
  }

  def setupUI(): Unit = {
    jQuery("""<button type="button">Click me!</button>""")
      .appendTo(jQuery("body"))
    jQuery("body").append("<p>World</p>")
  }

  def addClickedMessage(): Unit = {
    val dropDown = new DropDown(textUpdate = Some(println))
    append(dropDown)
  }

}

trait Appending {
  def append(heading: TypedTag[HTMLElement]): Unit =
    dom.document.body.appendChild(heading.render)

  def append(component: WebComponent): Unit =
    dom.document.body.appendChild(component.render)

}

trait WebComponent {
  def render: HTMLElement
}

class DropDown(textUpdate: Option[(String => Unit)] = None) extends WebComponent {

  private val html = input(
    placeholder := "Type to uppercase"
  ).render

  html.onkeyup = { e: KeyboardEvent =>
    textUpdate.foreach { f =>
      val value = html.value
      f(value)
    }
  }

  override def render: HTMLElement = html
}
