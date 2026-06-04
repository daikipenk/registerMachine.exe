package instructionCommands

import Machine

class JZERO (val machine: Machine, val opcode: String): Command {
    override fun execute() {
        if (machine.memory.get(0) == 0) {
            var succeeded: Boolean = false
            for (i in 0..machine.program.size-1) {
                if (machine.program[i].label == opcode) {
                    machine.pointer.value = i -1 // This is needed because +1 is added after all commands
                    succeeded = true
                    break
                }
            }
            if (!succeeded) println("Label not found!")
        }
        else machine.pointer.value += 1
    }
}