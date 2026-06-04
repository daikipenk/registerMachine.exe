package instructionCommands

import Machine
import utilityClasses.Addressing
import utilityClasses.Operand

class STORE (val machine: Machine, val opcode: Operand) : Command {
    val mem = machine.memory

    override fun execute() {
        require(opcode.addressing != Addressing.immediate) {"value is not a register!"}

        when (opcode.addressing) {
            Addressing.direct -> mem.set(opcode.value, mem.get(0))
            Addressing.indirect -> mem.set(mem.get(opcode.value), mem.get(0))
        }
    }
}