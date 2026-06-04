package instructionCommands

import Machine

class JUMP (val machine: Machine, val opcode: String) : Command {
    override fun execute() {
        var succeeded: Boolean = false
        for (i in 0..machine.program.size-1) {
            if (machine.program[i].label == opcode) {
                machine.pointer.value = i
                succeeded = true
                break
            }
        }
        if (!succeeded) println("Label not found!")
    }
}