package atcoder

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SegTreeTest {
    class SegTreeNative<T>(
        val n: Int = 0,
        val op: (T, T) -> T,
        val e: () -> T,
        val v: MutableList<T> = MutableList(n){e()}
    ) {
        private val data = MutableList<T>(n) { e() }

        fun set(p: Int, x: T) {
            data[p] = x
        }

        fun get(p: Int) = data[p]

        fun prod(l: Int, r: Int): T {
            var sum = e()
            for (i in l until r) sum = op(sum, data[i])
            return sum
        }

        fun allProd() = prod(0, n)
    }

    fun op(a: String, b: String): String{
        assert(a == "$" || b == "$" || a <= b)
        if (a == "$") return b
        if (b == "$") return a
        return a + b
    }

    fun e() = "$"

    @Test
    fun segTreeTestZero() {
        val seg = SegTree<String>(0, ::op, ::e)
        assertEquals("$", seg.allProd())
        val seg2 = SegTree<String>(0, ::op, ::e)
        assertEquals("$", seg2.allProd())
    }

    @Test
    fun segTreeTestOne() {
        val seg = SegTree<String>(1, ::op, ::e)
        assertEquals("$", seg.allProd())
        assertEquals("$", seg.get(0))
        assertEquals("$", seg.prod(0, 1))
        seg.set(0 ,"dummy")
        assertEquals("dummy", seg.get(0))
        assertEquals("$", seg.prod(0, 0))
        assertEquals("dummy", seg.prod(0, 1))
        assertEquals("$", seg.prod(1, 1))
    }

    @Test
    fun segTreeTestCompareNative() {
        for (n in 0 until 30) {
            val seg = SegTree<String>(n, ::op, ::e)
            val segNative = SegTreeNative<String>(n, ::op, ::e)

            for (i in 0 until n){
                var s = ""
                s += ('a'.toInt() + i).toChar()
                seg.set(i, s)
                segNative.set(i, s)
            }

            for (l in 0..n) {
                for (r in l..n) {
                    assertEquals(segNative.prod(l, r), seg.prod(l, r))
                }
            }
        }
    }
}