package com.anand.lists

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

class LinkedList[T] {

	private[this] var head: ListNode[T] = EmptyListNode
	private[this] var tail: ListNode[T] = EmptyListNode

	def add(data: T) = {

    val node = LinkedListNode(data)

		if(head == EmptyListNode) {
			head = node
      tail = head
		} else {
      val prevTail = tail.asInstanceOf[LinkedListNode[T]]
			prevTail.next = node
      tail = prevTail.next
		}
	}

  def remove(data: T) = {
    var prevNode: ListNode[T] = EmptyListNode
    var currentNode = head

    breakable {
      while(currentNode != EmptyListNode) {
          val nextNode = currentNode.asInstanceOf[LinkedListNode[T]].next
          if(prevNode == EmptyListNode && currentNode.asInstanceOf[LinkedListNode[T]].data == data) {
            println(s"deleting the head node")
            head = nextNode
            break
          } else if(prevNode != EmptyListNode && currentNode.asInstanceOf[LinkedListNode[T]].data == data) {
            // println(s"deleting node with data = $data")
            prevNode.asInstanceOf[LinkedListNode[T]].next = nextNode
            if (nextNode == EmptyListNode) {
              tail = prevNode
            }
            break
          } else {
            println(s"No match found. Iterate...")
            prevNode = currentNode
            currentNode = nextNode
          }
      }
    }
  }

  def printList(): String = {
    val res = new ArrayBuffer[T]()
    var node = head
    while(node != EmptyListNode) {
      val currentNode = node.asInstanceOf[LinkedListNode[T]]
      println(s"current node data = ${currentNode.data}")
      res += currentNode.data
      node = currentNode.next
    }

    s"${res.mkString("->")}"
  }

  def size() = {
    if(head == EmptyListNode) 0
    else {
      var currentNode = head
      var count = 0
      while(currentNode != EmptyListNode) {
        count = count + 1
        currentNode = currentNode.asInstanceOf[LinkedListNode[T]].next
      }
      count
    }
  } 

  def printMiddle(): Unit = {
    var fastPtr = head
    var slowPtr = head

    while(fastPtr != EmptyListNode && fastPtr.asInstanceOf[LinkedListNode[T]].next != EmptyListNode) {
      fastPtr = fastPtr.asInstanceOf[LinkedListNode[T]].next.asInstanceOf[LinkedListNode[T]].next
      slowPtr = slowPtr.asInstanceOf[LinkedListNode[T]].next
    }

    println(s"Middle element is = ${slowPtr.asInstanceOf[LinkedListNode[T]].data}")

  }

  def reverseList() = {

    var prevNode: ListNode[T] = EmptyListNode
    var currentNode = head
    val tempTail = head
    val tempHead = tail

    while(currentNode != EmptyListNode) {
      val nextNode = currentNode.asInstanceOf[LinkedListNode[T]].next
      currentNode.asInstanceOf[LinkedListNode[T]].next = prevNode

      prevNode = currentNode
      currentNode = nextNode
    }

    head = tempHead
    tail = tempTail

  }

}

trait ListNode[+T]
case object EmptyListNode extends ListNode[Nothing]
case class LinkedListNode[T](data: T, var next: ListNode[T] = EmptyListNode) extends ListNode[T]