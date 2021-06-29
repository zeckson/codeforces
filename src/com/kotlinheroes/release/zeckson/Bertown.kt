package com.kotlinheroes.release.zeckson

import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    val max = scanner.nextInt()
    for (i in 1..max) {
        val friends = scanner.nextInt()
        val startDay = scanner.nextInt()
        var max = 0
        for (friend in 1..friends) {
            val start = scanner.nextInt()
            val end = scanner.nextInt()
            if (start <= startDay) {
                val stay = end + 1 - startDay
                if (stay > max) {
                    max = stay
                }
            }
        }
        println(max)
    }
}