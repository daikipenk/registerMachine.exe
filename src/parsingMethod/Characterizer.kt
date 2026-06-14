package parsingMethod

class Characterizer {
    fun convertToChar(bytes: ByteArray) : Sequence<Char> { // Get characters and return 'tokens'
        return sequence {
            for (byte in bytes) {
                yield(byte.toInt().toChar())
            }
        }
    }
}