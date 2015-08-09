package tutorial.webapp

import org.scalajs.dom.raw.{HTMLElement, KeyboardEvent}

import scalatags.JsDom.all._

class DropDown(textUpdate: (String => Unit) = NoOps.String) extends WebComponent {

  private val html = input(
    placeholder := "Type to uppercase"
  ).render

  html.onkeyup = { e: KeyboardEvent =>
    textUpdate(html.value)
  }

  override def render: HTMLElement = html
}
