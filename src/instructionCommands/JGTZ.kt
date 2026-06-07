package instructionCommands

import Machine

class JGTZ (val machine: Machine, val opcode: String): Command {
    override fun execute() {
        if (machine.memory.get(0) > 0) {
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
        else {machine.pointer.set(machine.pointer.getValue() + 1)}
    }
}