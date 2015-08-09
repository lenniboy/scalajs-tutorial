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

class TextInput(textUpdate: (String => Unit) = NoOps.String) extends WebComponent {

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

  private val paragraph = p(initialText).render
  private val b = blockquote().render

  override def render: HTMLElement = {
    b.appendChild(paragraph)
    b
  }

  def setOutput(o: String) = paragraph.textContent = o
}

class UpperCaseOutput extends TextOutput {
  override def setOutput(o: String) = super.setOutput(o.toUpperCase)
}
