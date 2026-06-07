import instructionCommands.HALT
import utilityClasses.Input
import utilityClasses.Memory
import utilityClasses.Pointer
import utilityClasses.Instruction

class Machine (fileContent: List<String>, input: String) {
    val inputTape = Input(input.toCharArray().toList())
    val memory = Memory();
    val pointer = Pointer()
    val program: List<Instruction> = Parser(this).parseFile(fileContent)

    fun startProgram() {
        while (program.size > pointer.getValue()) {
            val instruction = program[pointer.getValue()]
            if (instruction.command is HALT) {break} // Check if command == HALT command

            instruction.command.execute()
            pointer.set(pointer.getValue()+1)
        }
    }
}