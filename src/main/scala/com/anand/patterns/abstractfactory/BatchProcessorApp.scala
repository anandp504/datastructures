package com.anand.patterns.abstractfactory

object BatchProcessorApp extends App {

  override def main(args: Array[String]) = {
    val fileType = args(0)

    val batchProcessor = if(fileType.equalsIgnoreCase("XML")) {
      new XMLBatchProcessor()
    } else if(fileType.equalsIgnoreCase("csv")) {
      new CSVBatchProcessor()
    } else if(fileType.equalsIgnoreCase("Text")) {
      new TextBatchProcessor()
    } else {
      null
    }

    batchProcessor.processBatch(args(1))
  }

}
