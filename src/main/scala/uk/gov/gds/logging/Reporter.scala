package uk.gov.gds.logging

import uk.gov.gds.io.reportWriter
import org.joda.time.DateTime


sealed abstract class Error(errorType: String) {
  override def toString = errorType
}
object RowParseError extends Error("rowparse")


object Reporter {


  reportWriter.writeStrings(List("\n", "=== Starting Run at " + new DateTime + " ===\n"))

  def report(fileName: String, errorType: Error, errorData: Option[String]) {
    report(List(fileName, errorType, errorData.getOrElse("")).mkString(",") + "\n")
  }

  def report(lines: List[String])  {
    reportWriter.writeStrings(lines, "\n")
  }

  def report(line: String)  {
    reportWriter.write(line)
  }
}