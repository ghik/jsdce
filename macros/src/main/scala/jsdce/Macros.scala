package jsdce

import scala.reflect.macros.whitebox

class Macros(val c: whitebox.Context) {
  import c.universe._

  def light(annottees: c.Expr[Any]*): Tree = {
    val trees = annottees.map(_.tree).toList
    q"..$trees"
  }
}
