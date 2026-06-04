package instructionCommands

import Machine
import utilityClasses.Addressing
import utilityClasses.Operand

class READ (val machine: Machine, val opcode: Operand) : Command {
    val mem = machine.memory

    override fun execute() {
        require(opcode.addressing != Addressing.immediate) {"value is not a register!"}

        when (opcode.addressing) {
            Addressing.direct -> mem.set(opcode.value, machine.inputTape.next().code) // .code transforms char into ASCII code
            Addressing.indirect -> mem.set(opcode.value, machine.inputTape.next().code)
        }
    }
}