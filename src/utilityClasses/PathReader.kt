package utilityClasses

import java.io.File

class PathReader {
    fun readPath(filePath: String) : File {
        return getFileContent(filePath)
    }

    private fun getFileContent(filePath: String) : File {
        try {
            return File(filePath)
        }
        catch (_: Exception) {
            println("File path must exist!")
            return tryNewFile() // This will continuously loop until found an existing file
        }
    }

    private fun tryNewFile() : File {
        while (true) {
            print("Please enter a valid path: ")
            try {
                return File(readln().trim())
            }
            catch (e: Exception) {
                println("File path must exist!")
            }
        }
    }
}