package atcoder

class Dsu(private val n: Int = 0) {
    // root node: -1 * component size
    // otherwise: parent
    private var parentOrSize = IntArray(n) { -1 }

    fun merge(a: Int, b: Int): Int {
        assert(a in 0 until n)
        assert(b in 0 until n)
        var x = leader(a)
        var y = leader(b)
        if (x == y) return x
        if (-parentOrSize[x] < -parentOrSize[y]) {
            val tmp = x
            x = y
            y = tmp
        }
        parentOrSize[x] += parentOrSize[y]
        parentOrSize[y] = x
        return x
    }

    fun same(a: Int, b: Int): Boolean {
        assert(a in 0 until n)
        assert(b in 0 until n)
        return leader(a) == leader(b)
    }

    fun leader(a: Int): Int {
        assert(a in 0 until n)
        if (parentOrSize[a] < 0) return a
        parentOrSize[a] = leader(parentOrSize[a])
        return parentOrSize[a]
    }

    fun size(a: Int): Int {
        assert(a in 0 until n)
        return -parentOrSize[leader(a)]
    }
}