package com.anand.patterns.abstractfactory

import java.io.File

class CSVBatchProcessor extends BatchProcessor {
  override def createParser(file: File) = {
    new CSVParser(file)
  }
}
