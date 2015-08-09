package tutorial.webapp

import org.scalajs.dom.raw.HTMLElement

trait WebComponent {
  def render: HTMLElement
}

object NoOps{
  val String = { s:String => () }
}
