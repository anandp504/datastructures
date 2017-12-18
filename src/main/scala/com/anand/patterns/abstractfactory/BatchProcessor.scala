package com.anand.patterns.abstractfactory

import java.io.File

abstract class BatchProcessor {

  final def processBatch(fileName: String): Unit = {
    val file = openFile(fileName)
    val parser: Parser = createParser(file)
    val records = parser.parse
    processRecords(records)
    writeSummary()
  }

  def createParser(file: File): Parser

  def openFile(fileName: String): File = {
    println(s"Creating file object $fileName")
    new File(fileName)
  }

  def processRecords(records: List[Record]) = {
    println("processing records...")
  }

  def writeSummary() = {
    println("writing summary...")
  }

}
