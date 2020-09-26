package atcoder

fun safe_mod(x: Long, m: Long): Long {
    assert(1 <= m)
    var ret = x % m
    if (ret < 0) ret += m
    return ret
}

class Barrett(var m: Int){

}