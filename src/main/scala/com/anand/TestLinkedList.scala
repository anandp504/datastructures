package com.anand

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class TestLinkedList[T] extends List[T] {

  private[this] var list = new ArrayBuffer[Node[T]]()
  private[this] var head: Node[T] = _
  private[this] var tail: Node[T] = _

  val linkedList = new mutable.LinkedList[String]()


  override def add(e: T): Unit = {

  }
  /*
  override def add(e: T): Unit = {

    if(list.isEmpty) {
      val head = Node(e, None)
      list += head
    } else {
      val lastNode = list.last
      val node = Node(e, None)
      val updatedNode = lastNode.copy[T](data = lastNode.data, next = Some(node))
      list.update(list.size - 1, updatedNode)
      list += node
    }
  }
  */

  override def remove(e: T): Unit = {

  }

  def reverseList(): Unit = {
    if(list.nonEmpty) {
      list.map {
        l =>

      }
    }
  }

  def printElements(): String = {
    list.mkString(",")
  }

}

trait List[T] {
  def add(e: T)
  def remove(e: T)
}

case class Node[T](data: T, next: Option[Node[T]])
