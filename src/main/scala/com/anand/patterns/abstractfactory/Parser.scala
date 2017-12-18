package com.anand.patterns.abstractfactory

import java.io.File

trait Parser {
  def parse: List[Record]
}

case class Record(data: String)

class XMLParser(file: File) extends Parser {
  override def parse = {
    println("Parsing XML records...")
    List[Record]()
  }
}

class TextParser(file: File) extends Parser {
  override def parse = {
    println("Parsing Text records...")
    List[Record]()
  }
}

class CSVParser(file: File) extends Parser {
  override def parse() = {
    println("Parsing CSV records...")
    List[Record]()
  }
}
