import utilityClasses.Memory
import utilityClasses.Pointer
import instructionCommands.Command

class Machine {
    val memory = Memory(mutableListOf());
    val pointer = Pointer()
    val program: List<Command> = listOf()

    fun startProgram() {

    }
}