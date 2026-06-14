package instructionCommands

import CommandVisitor.CommandVisitor

class JUMP (val opcode: String) : Command {
    override fun accept(visitor: CommandVisitor) {
        visitor.visitJUMP(this)
    }
}