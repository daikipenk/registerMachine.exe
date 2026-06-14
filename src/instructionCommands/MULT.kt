package instructionCommands

import CommandVisitor.CommandVisitor
import utilityClasses.Operand

class MULT (val opcode: Operand) : Command {
    override fun accept(visitor: CommandVisitor) {
        visitor.visitMULT(this)
    }
}