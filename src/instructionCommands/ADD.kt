package instructionCommands

import CommandVisitor.CommandVisitor
import utilityClasses.Operand

class ADD (val opcode: Operand) : Command {
    override fun accept(visitor: CommandVisitor) {
        visitor.visitADD(this)
    }
}