package atcoder

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DsuTest {
    @Test
    fun dsuTestSimple() {
        val dsu = Dsu(2)
        assertFalse(dsu.same(0, 1))
        val x = dsu.merge(0, 1)
        assertEquals(x, dsu.leader(0))
        assertEquals(x, dsu.leader(1))
        assertTrue(dsu.same(0, 1))
        assertEquals(2, dsu.size(0))
    }

    @Test
    fun dsuTestLine() {
        val num = 500000
        val dsu = Dsu(num)
        for (i in 0 until num - 1) {
            dsu.merge(i, i + 1)
        }
        assertEquals(num, dsu.size(0))
    }

    @Test
    fun dsuTestLineReverse() {
        val num = 500000
        val dsu = Dsu(num)
        for (i in num-1 downTo 1){
            dsu.merge(i, i - 1)
        }
        assertEquals(num, dsu.size(0))
    }
}