package com.tajpure.scheme.compiler.ast

import com.tajpure.scheme.compiler.Scope
import com.tajpure.scheme.compiler.value.Value
import com.tajpure.scheme.compiler.value.FloatValue

class FloatNum(_content: String, _file: String, _start: Int, _end: Int, _row: Int, _col: Int)
  extends Node(_file, _start, _end, _row, _col) {
  
  val content: String = _content
  
  val value: Float = content.toFloat

  def interp(s: Scope): Value = {
    new FloatValue(value)
  }

  def typecheck(s: Scope): Value = {
    null
  }
  
  def codegen(s: Scope): Value = {
    null
  }
  
  override
  def toString(): String = {
    content
  }
  
}