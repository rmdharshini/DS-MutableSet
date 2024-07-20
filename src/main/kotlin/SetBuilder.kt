interface SetBuilder {
    fun size(): Int

    fun contains(element: Int): Boolean

    fun add(element: Int): Boolean

    fun addAll(elements: Array<Int>): Boolean

    fun clear()

    fun remove(element: Int): Boolean

    fun removeAll(elements: Array<Int>): Boolean

    fun getAll(): Array<Int>
}