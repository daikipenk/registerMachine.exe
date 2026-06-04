package utilityClasses

import java.io.File

class PathReader {
    fun readPath(filePath: String) : List<String> {
        return getFileContent(filePath)
    }

    private fun getFileContent(filePath: String) : List<String> {
        try {
            return File(filePath).readLines()
        }
        catch (_: Exception) {
            println("File path must exist!")
            return tryNewFile() // This will continuously loop until found an existing file
        }
    }

    private fun tryNewFile() : List<String> {
        while (true) {
            print("Please enter a valid path: ")
            try {
                return File(readln().trim()).readLines()
            }
            catch (e: Exception) {
                println("File path must exist!")
            }
        }
    }
}