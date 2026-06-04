package instructionCommands

import Machine
import utilityClasses.Addressing
import utilityClasses.Operand

class READ (val machine: Machine, val opcode: Operand) : Command {
    val register = machine.memory.register

    override fun execute() {
        require(opcode.addressing != Addressing.immediate) {"value is not a register!"}

        when (opcode.addressing) {
            Addressing.direct -> register[opcode.value] = machine.inputTape.next().code // .code transforms char into ASCII code
            Addressing.indirect -> register[register[opcode.value]] = machine.inputTape.next().code
        }
    }
}