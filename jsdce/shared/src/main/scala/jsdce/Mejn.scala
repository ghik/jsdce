package jsdce

import com.avsystem.commons.serialization.{GenCodec, HasGenCodec}

import scala.collection.mutable

case class Boiler(int: Int, str: String)
object Boiler extends HasGenCodec[Boiler]

object Mejn {
  def main(args: Array[String]): Unit = {
    val boilerMap = new mutable.HashMap[Boiler, String]
    val boiler = Boiler(42, "fuu")
    boilerMap(boiler) = boiler.toString
    println(boiler.productPrefix)
    boiler.productIterator.foreach(println)
    boilerMap foreach {
      case (Boiler(int, str), _) => println(int, str)
    }
    GenCodec.write(null, boiler)
    GenCodec.read[Boiler](null)

    type Tester = Tester2

    def Tester = Tester2

    val tester = Tester(42, "fuu", 42, "fuu", 42, "fuu", 42, "fuu")
    GenCodec.write(null, tester)
    GenCodec.read[Tester](null)

    val TesterObj: TesterObj2.type = TesterObj2

    GenCodec.write(null, TesterObj)
    GenCodec.read[TesterObj.type](null)
  }
}
