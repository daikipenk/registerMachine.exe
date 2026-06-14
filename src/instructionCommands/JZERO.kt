package instructionCommands

import CommandVisitor.CommandVisitor

class JZERO (val opcode: String): Command {
    override fun accept(visitor: CommandVisitor) {
        visitor.visitJZERO(this)
    }
}