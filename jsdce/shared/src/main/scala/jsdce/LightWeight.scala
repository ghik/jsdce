package jsdce

import scala.runtime.ScalaRunTime

abstract class LightWeight extends Product {
  override def hashCode: Int = ScalaRunTime._hashCode(this)
  override def equals(obj: Any): Boolean = obj match {
    case self: AnyRef if self eq this => true
    case prod: Product => canEqual(prod) && productIterator.sameElements(prod.productIterator)
    case _ => false
  }
  override def toString: String = ScalaRunTime._toString(this)
  override def productIterator: Iterator[Any] = super.productIterator
  def canEqual(that: Any): Boolean = getClass.isAssignableFrom(that.getClass)
}

abstract class LightWeight2 extends Product {
  def canEqual(that: Any) = ???
  override def productIterator = super.productIterator
  override def productPrefix = super.productPrefix
  override def hashCode() = super.hashCode()
  override def equals(obj: Any) = super.equals(obj)
  override def toString = super.toString
}
