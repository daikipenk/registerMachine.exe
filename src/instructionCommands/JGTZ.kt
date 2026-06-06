package instructionCommands

import Machine

class JGTZ (val machine: Machine, val opcode: String): Command {
    override fun execute() {
        if (machine.memory.get(0) > 0) {
            var succeeded: Boolean = false
            for (i in 0..machine.program.size-1) {
                if (machine.program[i].label == opcode) {
                    machine.pointer.set(i-1) // This is needed because +1 is added after all commands
                    succeeded = true
                    break
                }
            }
            if (!succeeded) println("Label not found!")
        }
        // No need to add +1 here because it is already added in the machine
    }
}