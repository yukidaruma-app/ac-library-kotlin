package atcoder

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MathTest {
    private fun powModNative(x: Long, n: Long, mod: Int): Long {
        val y = (x % mod + mod) % mod   // native safe_mod
        var z = 1L
        for (i in 1..n) {
            z = (z * y) % mod
        }
        return z % mod
    }

    @Test
    fun powModTest() {
        for (a in -100L..100L) {
            for (b in 0L..100L) {
                for (c in 1..100) {
                    assertEquals(powModNative(a, b, c), powMod(a, b, c))
                }
            }
        }
    }

    @Test
    fun invModTest() {
        for (a in -100L..100L){
            for (b in 1L..1000L) {
                if (gcd(safeMod(a, b), b) != 1L) continue
                val c = invMod(a, b)
                assertTrue(0L <= c)
                assertTrue(c < b)
                assertEquals(1 % b, ((a * c) % b + b) % b)
            }
        }
    }
}