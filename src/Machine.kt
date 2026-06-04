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

    var haltProgram: Boolean = false
    fun startProgram() {
        while (program.size > pointer.value) {
            val instruction = program[pointer.value]
            if (instruction.command is HALT) {haltProgram = true} // Check if command == HALT command

            instruction.command.execute()
            pointer.value += 1
        }
    }
}