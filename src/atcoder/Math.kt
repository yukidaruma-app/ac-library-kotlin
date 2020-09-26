// https://atcoder.github.io/ac-library/production/document_ja/math.html

package atcoder

// return x ^ n mod m
fun powMod(x: Long, n: Long, m: Int): Long {
    assert(0 <= n && 1 <= m)
    if (m == 1) return 0
    var r = 1L
    var y = safeMod(x, m.toLong())
    var mn = n
    while (0 < mn) {
        if (mn.and(1L) == 1L) r = r * y % m
        y = y * y % m
        mn = mn.shr(1)
    }
    return r
}

// Constraints: gcd(x, m) == 1
fun invMod(x: Long, m: Long): Long {
    assert(1 <= m)
    var z = invGcd(x, m)
    assert(z.first == 1L)
    return z.second
}