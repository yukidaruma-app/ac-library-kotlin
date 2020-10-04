package atcoder

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class InternalMathTest {
    @Test
    fun ceilPow2Test() {
        assertEquals(0, ceilPow2(0))
        assertEquals(0, ceilPow2(1))
        assertEquals(1, ceilPow2(2))
        assertEquals(2, ceilPow2(3))
        assertEquals(2, ceilPow2(4))
        assertEquals(3, ceilPow2(5))
        assertEquals(3, ceilPow2(6))
        assertEquals(3, ceilPow2(7))
        assertEquals(3, ceilPow2(8))
        assertEquals(4, ceilPow2(9))
        assertEquals(30, ceilPow2(1.shl(30)))
        assertEquals(31, ceilPow2(1.shl(30) + 1))
        assertEquals(31, ceilPow2(Int.MAX_VALUE.toLong()))
    }
}