package utilityClasses

data class Memory(var register: MutableList<Int> = mutableListOf()) {
    fun get (index: Int) : Int {
        if (index > register.size-1) {
            expand(index)
        }
        return register[index]
    }

    fun set (index: Int, value: Int) {
        if (index > register.size-1) {
            expand(index)
        }
        register[index] = value
    }

    private fun expand (index: Int) {
        val initialSize = register.size
        for(i in initialSize..index) {
            register.add(0)
        }
    }
}