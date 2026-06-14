package instructionCommands

import CommandVisitor.CommandVisitor

interface Command {
    fun accept(visitor: CommandVisitor)
}