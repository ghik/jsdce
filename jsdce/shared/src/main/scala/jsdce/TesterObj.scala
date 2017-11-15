package jsdce

import com.avsystem.commons.serialization.GenCodec

case object TesterObj1 {
  implicit val codec: GenCodec[TesterObj1.type] = GenCodec.materialize
}

case object TesterObj2 extends LightWeight {
  implicit val codec: GenCodec[TesterObj2.type] = GenCodec.materialize
}

object TesterObj3 {
  implicit val codec: GenCodec[TesterObj3.type] = GenCodec.materialize
}
