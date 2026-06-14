package instructionCommands

import CommandVisitor.CommandVisitor
import utilityClasses.Operand

class SUB (val opcode: Operand) : Command {
    override fun accept(visitor: CommandVisitor) {
        visitor.visitSUB(this)
    }
}