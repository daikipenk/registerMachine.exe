package instructionCommands

import Interpreter

class JUMP (val machine: Interpreter, val opcode: String) : Command {
    override fun execute() {
        var succeeded: Boolean = false
        for (i in 0..machine.program.size-1) {
            if (machine.program[i].label == opcode) {
                machine.pointer.set(i)
                succeeded = true
                break
            }
        }
        if (!succeeded) throw Exception("Label not found!")
    }
}