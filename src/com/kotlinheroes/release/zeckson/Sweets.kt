package com.kotlinheroes.release.zeckson

import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    val max = scanner.nextInt()
    for (i in 1..max) {
        val n = scanner.nextInt()
        val k = scanner.nextInt()
        var sweets = scanner.next()

        var eaten = 0
        var target = 0
        while (sweets.contains('1')) {
            eaten++
            sweets = sweets.substring(0, target) + sweets.substring(target + 1, sweets.length)
            if (sweets.isEmpty()) {
                continue
            }
            target = ((target - 1 + k) % sweets.length)
        }
        println(eaten)
    }
}