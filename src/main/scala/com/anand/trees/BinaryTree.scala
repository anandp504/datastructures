package com.anand.trees

class BinaryTree[T] {

  private[this] var root: TreeNode[T] = EmptyTreeNode

  def insert(data: T): Unit = {
    val newRoot = insert(root, data)
    println(newRoot)
    root = newRoot
  }

  def insert(node: TreeNode[T], data: T): TreeNode[T] = {
    // println(s"data to be inserted = $data")
    var root = node
    root match {
      case EmptyTreeNode => root = BinaryTreeNode(data)
      case BinaryTreeNode(d, left, right) =>
        //println(s"current-data = $d left-leaf = ${left.isLeaf()} right-leaf = ${right.isLeaf()}")
        if (node.isLeaf()) {
          root.asInstanceOf[BinaryTreeNode[T]].left = insert(left, data)
        } else {
          if ((left == EmptyTreeNode && right == EmptyTreeNode)
            || (left.isLeaf() && right.isLeaf())
            || left.children() == 1) {
            root.asInstanceOf[BinaryTreeNode[T]].left = insert(left, data)
          } else {
            root.asInstanceOf[BinaryTreeNode[T]].right = insert(right, data)
          }
        }
    }
    root
  }

  /*
  def insert(node: Option[BinaryTreeNode[T]], data: T): Option[BinaryTreeNode[T]] = {
    if(node.isEmpty) {
      Some(BinaryTreeNode(data))
    } else {
      if(node.get.left.isEmpty) {
        node.get.left = insert(node.get.left, data)
        node.get.left
      } else if(node.get.right.isEmpty) {
        node.get.right = insert(node.get.right, data)
        node.get.right
      } else {
        null
      }
    }
  }
  */

  def inorder: Unit = {
    inorderTraversal(root)
  }

  def inorderTraversal(node: TreeNode[T]): Unit = {
    node match {
      case EmptyTreeNode =>
      case BinaryTreeNode(d, left, right) =>
        inorderTraversal(left)
        println(s"$d")
        inorderTraversal(right)
    }
  }

  def preOrderTraversal(node: TreeNode[T]): Unit = {
    node match {
      case EmptyTreeNode =>
      case BinaryTreeNode(d, left, right) =>
        println(s"$d")
        preOrderTraversal(left)
        preOrderTraversal(right)
    }
  }

  def postOrderTraversal(node: TreeNode[T]): Unit = {
    node match {
      case EmptyTreeNode =>
      case BinaryTreeNode(d, left, right) =>
        postOrderTraversal(left)
        postOrderTraversal(right)
        println(s"$d")    
    }
  }

  def getHeight(node: TreeNode[T]): Int = {
    node match {
      case EmptyTreeNode => -1
      case BinaryTreeNode(d, left, right) =>
        Math.max(getHeight(left), getHeight(right)) + 1
    }
  }

  def isBalanced: Boolean = {
    isBalanced(root)
  }

  def isBalanced(node: TreeNode[T]): Boolean = {
    node match {
      case EmptyTreeNode => true
      case BinaryTreeNode(d, left, right) => {
        val heightDiff = getHeight(left) - getHeight(right)
        if(heightDiff > 1)
          false
        else
          isBalanced(left) && isBalanced(right)
      }

    }
  }

}

trait TreeNode[+T] {
  def isLeaf(): Boolean
  def children(): Int
}

case object EmptyTreeNode extends TreeNode[Nothing] {
  override def isLeaf(): Boolean = false
  override def children(): Int = 0
}

case class BinaryTreeNode[T](data: T, var left: TreeNode[T] = EmptyTreeNode,
                             var right: TreeNode[T] = EmptyTreeNode) extends TreeNode[T] {
  override def isLeaf(): Boolean = {
    left == EmptyTreeNode && right == EmptyTreeNode
  }

  override def children(): Int = {
    if(isLeaf()) 0
    else if(left != EmptyTreeNode && right != EmptyTreeNode) 2
    else 1
  }
}
