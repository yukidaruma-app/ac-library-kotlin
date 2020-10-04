// https://atcoder.github.io/ac-library/production/document_ja/segtree.html

package atcoder

class SegTree<T>(
    val n: Int = 0,
    val op: (T, T) -> T,
    val e: () -> T,
    val v: MutableList<T> = MutableList(n){e()}
) {
    private val log = ceilPow2(n.toLong())
    private val size = 1.shl(log)
    private val data = MutableList<T>(2 * size) { e() }

    init {
        for (i in 0 until n) data[size + i] = v[i]
        for (i in size - 1 downTo 1) update(i)
    }

    fun set(p: Int, x: T) {
        assert(p in 0 until n)
        var mp = p + size
        data[mp] = x
        for (i in 1..log) update(mp.shr(i))
    }

    fun get(p: Int): T {
        assert(p in 0 until n)
        return data[p + size]
    }

    fun prod(l: Int, r: Int): T {
        assert(l in 0..r && r <= n)
        var sml = e()
        var smr = e()
        var ml = l + size
        var mr = r + size

        while (ml < mr) {
            if (ml.and(1) == 1) sml = op(sml, data[ml++])
            if (mr.and(1) == 1) smr = op(data[--mr], smr)
            ml = ml.shr(1)
            mr = mr.shr(1)
        }

        return op(sml, smr)
    }

    fun allProd() = data[1]

    private fun update(k: Int) {
        data[k] = op(data[2 * k], data[2 * k + 1])
    }

}