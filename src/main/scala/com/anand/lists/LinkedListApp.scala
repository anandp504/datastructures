package com.anand.lists

object LinkedListApp extends App {

  val linkedList = new LinkedList[String]()
  linkedList.add("test1")
  linkedList.add("test2")

  println(linkedList.printList())

  val listInts = new LinkedList[Int]()
  listInts.add(7)
  listInts.add(6)
  listInts.add(9)
  listInts.add(5)
  listInts.add(3)

  println(listInts.printList())

  listInts.reverseList()

  println(listInts.printList())

  println(listInts.size())

  listInts.printMiddle()

}
