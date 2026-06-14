package instructionCommands

import CommandVisitor.CommandVisitor
import utilityClasses.Operand

class READ (val opcode: Operand) : Command {
    override fun accept(visitor: CommandVisitor) {
        visitor.visitREAD(this)
    }
}