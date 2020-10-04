// Contains the original internal_math and internal_bit

package atcoder

fun safeMod(x: Long, m: Long): Long {
    assert(1 <= m)
    var ret = x % m
    if (ret < 0) ret += m
    return ret
}

fun gcd(a: Long, b: Long): Long {
    assert(0 <= a && 0 <= b)
    if (b == 0L) return a
    return gcd(b, a % b)
}

// return pair(g, x) s.t. g = gcd(a, b), xa = g (mod b), 0 <= x < b/g
fun invGcd(a: Long, b: Long): Pair<Long, Long> {
    val ma = safeMod(a, b)
    if (ma == 0L) return b to 0L

    var s = b
    var t = ma
    var m0 = 0L
    var m1 = 1L

    while (t > 0) {
        val u = s / t
        s -= t * u
        m0 -= m1 * u

        var tmp = s
        s = t
        t = tmp

        tmp = m0
        m0 = m1
        m1 = tmp
    }

    if (m0 < 0) m0 += b / s
    return s to m0
}

fun ceilPow2(n: Long): Int {
    var x = 0
    while (1L.shl(x) < n) x++
    return x
}