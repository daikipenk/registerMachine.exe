import utilityClasses.PathReader

fun main(vararg args: String) {
    require(args.size <= 2) {"required FilePath [INPUT]"}

    val file = PathReader().readPath(args[0])
    var input: String

    try {
        input = args[1]
    }
    catch (_: Exception) {
        print("Please enter an input: ")
        input = readln().trim()
    }

    Interpreter(file, input).interpret()
    // Machine(file, input).startProgram()
}