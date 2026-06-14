package instructionCommands

import CommandVisitor.CommandVisitor
import utilityClasses.Operand

class DIV (val opcode: Operand) : Command {
    override fun accept(visitor: CommandVisitor) {
        visitor.visitDIV(this)
    }
}