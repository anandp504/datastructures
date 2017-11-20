package com.anand.trees

object BinaryTreeApp extends App {

  val btree = new BinaryTree[Int]()
  //val input = Array[Int](10, 5, 7, 9, 15, 16, 20)
  val input = Array[Int](7, 4, 9, 1, 6)
  input.foreach(btree.insert(_))
  btree.inorder
  println("Is the tree balanced = " + btree.isBalanced)

}
