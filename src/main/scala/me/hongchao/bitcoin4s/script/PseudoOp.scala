package me.hongchao.bitcoin4s.script

sealed trait PseudoOp extends OpCode

case object OP_PUBKEYHASH extends PseudoOp { val value = 253 }
case object OP_PUBKEY extends PseudoOp { val value = 254 }
case object OP_INVALIDOPCODE extends PseudoOp { val value = 255 }

object PseudoOps {
  val all = Seq(OP_PUBKEYHASH, OP_PUBKEY, OP_INVALIDOPCODE)
}