package tutorial.webapp

import org.scalajs.dom.raw.{HTMLElement, KeyboardEvent}

import scalatags.JsDom.all._

trait WebComponent {
  def render: HTMLElement
}

object NoOps{
  val String = { s:String => () }
}

class MainContainer(children: Seq[WebComponent]) extends WebComponent {

  private val mainContainer = div(`class` := "container",
    h1("Web components with ScalaJS")
  )

  override def render: HTMLElement = {
    val container = mainContainer.render
    children.foreach( c => container.appendChild(c.render))
    container
  }

}

class DropDown(textUpdate: (String => Unit) = NoOps.String) extends WebComponent {

  private val html = input(
    placeholder := "Type to uppercase",
    `class` := "form-control",
    `type` := "text"
  ).render

  html.onkeyup = { e: KeyboardEvent =>
    textUpdate(html.value)
  }

  override def render: HTMLElement = html
}

class TextOutput(initialText: String = "") extends WebComponent {

  private val output = blockquote(
    p(initialText)
  )

  override def render: HTMLElement = output.render
}
