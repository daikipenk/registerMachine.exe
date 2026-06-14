package instructionCommands

import CommandVisitor.CommandVisitor

class HALT : Command {
    override fun accept(visitor: CommandVisitor) {
        visitor.visitHALT(this)
    }
}