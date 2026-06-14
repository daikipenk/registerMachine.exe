package instructionCommands

import CommandVisitor.CommandVisitor
import utilityClasses.Operand

class WRITE (val opcode: Operand) : Command {
    override fun accept(visitor: CommandVisitor) {
        visitor.visitWRITE(this)
    }
}