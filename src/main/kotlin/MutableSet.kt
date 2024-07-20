class MutableSet(elements: Array<Int>): SetBuilder {
    private var counter = 0

    private var array: Array<Int?> = arrayOfNulls(elements.size)

    init {
        for (element in elements) {
            if (element !in array) {
                this.array[counter++] = element
            }
        }
        array = array.copyOf(counter)
    }

    override fun size(): Int {
        return array.size
    }

    override fun contains(element: Int): Boolean {
        var isElementPresent = false

        for (i in array) {
            if (i == element) {
                isElementPresent = true
                break
            }
        }

        return isElementPresent
    }

    override fun add(element: Int): Boolean {
        var isSetModified = true

        for (i in array) {
            if (i == element) {
                isSetModified = false
                break
            }
        }
        array = array.copyOf(counter + 1)
        array[counter++] = element

        return isSetModified
    }

    override fun addAll(elements: Array<Int>): Boolean {
        var isSetModified = false

        array = array.copyOf(counter + elements.size)
        for (element in elements) {
            if (element !in array) {
                array[counter++] = element
                isSetModified = true
            }
        }
        array = array.copyOf(counter)

        return isSetModified
    }

    override fun clear() {
        while (counter >= 0) {
            array[counter-1] = null
        }
    }

    override fun remove(element: Int): Boolean {
        var isSetModified = false

        for (index in array.indices) {
            if (array[index] == element) {
                for (i in index until counter - 1) {
                    array[i] = array[i+1]
                    isSetModified = true
                }
                array[counter - 1] = null
                counter--
                break
            }
        }
        array = array.copyOf(counter)
        return isSetModified
    }

    override fun removeAll(elements: Array<Int>): Boolean {
        var isSetModified = false

        for (index in array.indices) {
            if (array[index] in elements) {
                for (i in index until counter - 1) {
                    array[i] = array[i+1]
                    isSetModified = true
                }
                array[counter - 1] = null
                counter--
                println(counter)
            }
        }
        array = array.copyOf(counter)

        return  isSetModified
    }

    override fun getAll(): Array<Int> {
        return array as Array<Int>
    }
}