package instructionCommands

import CommandVisitor.CommandVisitor
import utilityClasses.Operand

class LOAD (val opcode: Operand): Command {
    override fun accept(visitor: CommandVisitor) {
        visitor.visitLOAD(this)
    }
}