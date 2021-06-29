package com.kotlinheroes.release.zeckson

import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    val max = scanner.nextInt()
    for (i in 1..max) {
        val n = scanner.nextInt()
        var exists = false
        var max = n / 2
        val odd = n % 2 == 1
        if (odd) {
            max += 1
        }
        var prev = scanner.nextInt()
        for (c in 0 until max) {
            var next = scanner.nextInt()
            if (odd && c == max - 1) {
                val temp = prev
                prev = next
                next = temp
            } else {
                next = scanner.nextInt()
            }
            if ((next - prev) % 2 == 0) {
                exists = true
            }
        }
        println(if (exists) "YES" else "NO")
    }
}