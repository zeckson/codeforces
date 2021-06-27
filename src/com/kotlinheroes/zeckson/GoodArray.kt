package com.kotlinheroes.zeckson

import java.util.*
import kotlin.collections.ArrayList
/*
E. Хороший массив
ограничение по времени на тест2.0 с
ограничение по памяти на тест512 МБ
вводстандартный ввод
выводстандартный вывод
Назовем массив хорошим, если в нем есть элемент, равный сумме всех остальных элементов. Например, массив 𝑎=[1,3,3,7] — хороший, так как 𝑎4=7 равно 1+3+3.

Вам дан массив 𝑎 из 𝑛 целых чисел. Ваше задание — найти все такие индексы 𝑗 этого массива, что после удаления 𝑗-го элемента массив станет хорошим (назовем такие индексы красивыми).

Например, если 𝑎=[8,3,5,2], красивые индексы — 1 и 4:

при удалении 𝑎1 массив станет [3,5,2], и этот массив хороший;
при удалении 𝑎4 массив станет [8,3,5], и этот массив хороший.
Все удаления надо рассматривать независимо, то есть для каждого индекса надо удалить элемент, проверить, что массив теперь хороший, и после этого вставить элемент обратно.

Входные данные
В первой строке записано одно целое число 𝑛 (2≤𝑛≤2⋅105) — количество элементов в 𝑎.

Во второй строке записаны 𝑛 целых чисел 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤106) — элементы массива 𝑎.

Выходные данные
В первой строке выведите 𝑘 — количество таких индексов 𝑗 массива 𝑎, что после удаления 𝑗-го элемента массив станет хорошим (то есть, выведите количество красивых индексов).

Во второй строке выведите 𝑘 различных целых чисел 𝑗1,𝑗2,…,𝑗𝑘 в любом порядке — красивые индексы 𝑎.

Если таких индексов нет в массиве 𝑎, в первой строке выведите 0, а вторую строку оставьте пустой или не выводите вообще.

Примеры
входные данныеСкопировать
5
2 5 1 2 2
выходные данныеСкопировать
3
4 1 5
входные данныеСкопировать
4
8 3 5 2
выходные данныеСкопировать
2
1 4
входные данныеСкопировать
5
2 1 2 4 3
выходные данныеСкопировать
0

Примечание
В первом примере можно удалить любой элемент со значением 2, и массив станет [5,1,2,2]. Сумма массива равна 10, и есть элемент, равный сумме остальных (5=1+2+2).

Во втором примере можно удалить 8, и массив станет [3,5,2]. Сумма равна 10, и есть элемент, равный сумме остальных элементов (5=3+2). Также можно удалить 2, и массив станет [8,3,5]. Сумма равна 16, и есть элемент, равный сумме остальных (8=3+5).

В третьем примере нельзя удалением только одного элемента сделать массив хорошим.

 */
const val MAX_NUMBER = 1_000_002
val NUMBERS = Array(MAX_NUMBER) { 0 }

fun isGood(arr: Array<Int>, sum: Int, exclude: Int): Boolean {
    if (sum % 2 != 0) return false
    val pivot = sum / 2
    val found = NUMBERS[pivot]
    return (found != 0) and (found != exclude + 1)
}


fun main() {
    val scanner = Scanner(System.`in`)
    val length = scanner.nextInt()

    var sum = 0
    var idx = 1
    val array = Array<Int>(length) {
        val nextInt = scanner.nextInt()
        sum += nextInt
        NUMBERS[nextInt] = idx++
        nextInt
    }

    val beautifulList = ArrayList<Int>()
    for (i in array.indices) {
        val it = array[i]
        val good = isGood(array, sum - it, i)

        if (good) {
            beautifulList.add(i + 1)
        }
    }
    println(beautifulList.size)
    println(beautifulList.joinToString(" "))
}