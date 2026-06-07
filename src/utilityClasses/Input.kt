package utilityClasses

data class Input(val units: List<Char>) {
    private var index = 0

    fun next(): Int {
        if (units.size < index + 1) return 0
        return units[index++].code // This will increment to index afterwords...
    }
}