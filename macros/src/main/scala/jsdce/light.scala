package jsdce

import scala.annotation.{StaticAnnotation, compileTimeOnly}

@compileTimeOnly("enable macro paradise for macro annotations")
class light extends StaticAnnotation {
  def macroTransform(annottees: Any*): Any = macro Macros.light
}
