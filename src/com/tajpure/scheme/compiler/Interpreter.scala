package com.tajpure.scheme.compiler

import com.tajpure.scheme.compiler.parser.Parser

object Interpreter extends App {
  
  def interp(_source: String): Unit = {
    println(_source)
    println("=> " + Parser.parse(_source, "").interp(Scope.buildInitScope()))
  }
  
  interp("(define x 1)")
  
}