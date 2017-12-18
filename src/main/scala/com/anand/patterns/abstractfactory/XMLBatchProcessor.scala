package com.anand.patterns.abstractfactory

import java.io.File

class XMLBatchProcessor extends BatchProcessor {
  override def createParser(file: File) = {
    new XMLParser(file)
  }
}
