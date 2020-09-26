package atcoder

import org.junit.jupiter.api.Assertions.*

internal class MathTest {
    private fun pow_mod_native(x: Long, n: Long, mod: Int): Long {
        val y = (x % mod + mod) % mod   // native safe_mod
        var z = 1L
        for(i in 1..n){
            z = (z * y) % mod
        }
        return z % mod
    }

    @org.junit.jupiter.api.Test
    fun pow_mod_test() {
        for (a in -100L..100L){
            for (b in 0L..100L){
                for (c in 1..100){
                    assertEquals(pow_mod_native(a, b, c), pow_mod(a, b, c))
                }
            }
        }
    }
}