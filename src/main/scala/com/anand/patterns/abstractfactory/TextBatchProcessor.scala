package com.anand.patterns.abstractfactory

import java.io.File

class TextBatchProcessor extends BatchProcessor {
  override def createParser(file: File) = {
    new TextParser(file)
  }
}
