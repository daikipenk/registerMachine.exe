package instructionCommands

import CommandVisitor.CommandVisitor
import utilityClasses.Operand

class STORE (val opcode: Operand) : Command {
    override fun accept(visitor: CommandVisitor) {
        visitor.visitSTORE(this)
    }
}