package instructionCommands

import Machine

class JGTZ (val machine: Machine, val opcode: String): Command {
    override fun execute() {
        if (machine.memory.register[0] > 0) {
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
        else machine.pointer.value += 1
    }
}