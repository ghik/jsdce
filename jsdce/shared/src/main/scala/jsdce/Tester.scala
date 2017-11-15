package jsdce

import com.avsystem.commons.serialization._

case class Tester1(
  int1: Int,
  str1: String,
  int2: Int,
  str2: String,
  int3: Int,
  str3: String,
  int4: Int,
  str4: String,
)
object Tester1 extends HasGenCodec[Tester1]

case class Tester2(
  int1: Int,
  str1: String,
  int2: Int,
  str2: String,
  int3: Int,
  str3: String,
  int4: Int,
  str4: String,
) extends LightWeight
object Tester2 {
  implicit val codec: GenCodec[Tester2] = GenCodec.materialize
}

class Tester3(
  val int1: Int,
  val str1: String,
  val int2: Int,
  val str2: String,
  val int3: Int,
  val str3: String,
  val int4: Int,
  val str4: String,
)
object Tester3 {
  def apply(
    int1: Int,
    str1: String,
    int2: Int,
    str2: String,
    int3: Int,
    str3: String,
    int4: Int,
    str4: String) = new Tester3(int1, str1, int2, str2, int3, str3, int4, str4)

  def unapply(t3: Tester3): Option[(Int, String, Int, String, Int, String, Int, String)] =
    Some((t3.int1, t3.str1, t3.int2, t3.str2, t3.int3, t3.str3, t3.int4, t3.str4))

  implicit val codec: GenCodec[Tester3] = GenCodec.materialize
}