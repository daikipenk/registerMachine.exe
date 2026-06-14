package instructionCommands

import CommandVisitor.CommandVisitor

class JGTZ (val opcode: String): Command {
    override fun accept(visitor: CommandVisitor) {
        visitor.visitJGTZ(this)
    }
}