package com.tajpure.scheme.compiler.value.premitives

import com.tajpure.scheme.compiler.value.PrimFunc
import com.tajpure.scheme.compiler.value.Value
import com.tajpure.scheme.compiler.ast.Node
import com.tajpure.scheme.compiler.value.BoolValue
import com.tajpure.scheme.compiler.util.Log
import com.tajpure.scheme.compiler.exception.CompilerException
import com.tajpure.scheme.compiler.Scope

class GT extends PrimFunc(">" , 2) {
  
  def apply(args: List[Value], location: Node): Value = {
    if (args.size < 2 || (arity != -1 && arity == args.size)) {
      throw new CompilerException("Args don't match the '>' function", location)
    }
    
    args.foldLeft(new BoolValue(true).asInstanceOf[Value])((result, arg) => {
        if (result.isInstanceOf[BoolValue] && arg.isInstanceOf[BoolValue]) {
        new BoolValue(result.asInstanceOf[BoolValue].value > arg.asInstanceOf[BoolValue].value)
        }
        else {
          Log.error(location, "Args type error in function '>'")
          Value.VOID
        }
    })
  }
  
  def typecheck(args: List[Value], location: Node): Value= {
    null
  }
  
  def codegen(args: List[org.jllvm.value.Value], location: Node, s: Scope): org.jllvm.value.Value = {
    null
  }

  override
  def toString: String = {
    ">"
  }
  
}