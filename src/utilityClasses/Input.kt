package utilityClasses

data class Input(val units: List<Char>) {
    private var index = 0

    fun next(): Int {
        require(units.size >= index + 1) {"No more values to read!"}
        return units[index++].code // This will increment to index afterwords...
    }
}