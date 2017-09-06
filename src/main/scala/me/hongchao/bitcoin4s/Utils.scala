package me.hongchao.bitcoin4s

import java.nio.{ByteBuffer, ByteOrder}

import eu.timepit.refined.api.Refined
import eu.timepit.refined.collection.Size
import eu.timepit.refined.generic.Equal
import shapeless.nat._

package object Utils {
  implicit class Rich[T](value: T) {
    def toHex: String = "%02x".format(value)
  }

  implicit class RichSeqByte(bytes: Seq[Byte]) {
    def toHex: String = bytes.map(_.toHex).mkString
  }

  def toUInt8(bytes: Seq[Byte] Refined Size[Equal[_1]]): Int = {
    bytes.value.head.toShort
  }

  def toUInt16(bytes: Seq[Byte] Refined Size[Equal[_2]]): Int = {
    val byteBuffer = ByteBuffer.wrap(bytes.value.toArray).order(ByteOrder.LITTLE_ENDIAN)
    byteBuffer.getShort & 0xFFFF
  }

  def toUInt32(bytes: Seq[Byte] Refined Size[Equal[_4]]): Long = {
    val byteBuffer = ByteBuffer.wrap(bytes.value.toArray).order(ByteOrder.LITTLE_ENDIAN)
    byteBuffer.getInt & 0xFFFFFFFFL
  }
}