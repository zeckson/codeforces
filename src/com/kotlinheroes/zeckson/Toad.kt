package com.kotlinheroes.zeckson

/*
B. Прыгающая лягушка
ограничение по времени на тест2.0 с
ограничение по памяти на тест512 МБ
вводстандартный ввод
выводстандартный вывод
Сейчас лягушка стоит в позиции 0 на координатной оси 𝑂𝑥. Она прыгает по следующему алгоритму: первый прыжок — на 𝑎 вправо, второй прыжок — на 𝑏 влево, третий прыжок — на 𝑎 вправо, четвёртый прыжок — на 𝑏 влево, и так далее.

Формально:

если лягушка уже прыгнула четное число раз (перед текущим прыжком), то она прыгает от ее текущей позиции 𝑥 в позицию 𝑥+𝑎;
иначе она прыгает от ее текущей позиции 𝑥 в позицию 𝑥−𝑏.
Ваша задача — найти позицию лягушки после 𝑘 прыжков.

Но... Кое-что еще. Вы наблюдаете за 𝑡 различными лягушками, так что вам нужно ответить на 𝑡 независимых запросов.

Входные данные
Первая строка входных данных содержит одно целое число 𝑡 (1≤𝑡≤1000) — количество запросов.

Каждая из следующих 𝑡 строк содержит запросы (один запрос на строку).

Запрос описывается в виде трех целых чисел 𝑎,𝑏,𝑘 (1≤𝑎,𝑏,𝑘≤109) — длины прыжков двух типов и количество прыжков соответственно.

Выходные данные
Выведите 𝑡 целых чисел. 𝑖-е число должно быть равно ответу на 𝑖-й запрос.

Пример
входные данныеСкопировать
6
5 2 3
100 1 4
1 10 5
1000000000 1 6
1 1 1000000000
1 1 999999999
выходные данныеСкопировать
8
198
-17
2999999997
0
1
Примечание
В первом запросе лягушка прыгает на 5 позиций вправо, на 2 влево и еще раз на 5 позиций вправо, таким образом, ответ равен 5−2+5=8.

Во втором запросе лягушка прыгает на 100 позиций вправо, на 1 влево, на 100 вправо и еще раз на 1 влево, таким образом, ответ равен 100−1+100−1=198.

В третьем запросе ответ равен 1−10+1−10+1=−17.

В третьем запросе ответ равен 109−1+109−1+109−1=2999999997.

В пятом запросе все прыжки лягушки нейтрализуют друг друга, таким образом, ответ равен 0.

Шестой запрос почти эквивалентен пятому, но без последнего последнего прыжка, таким образом, ответ равен 1.

 */

import java.math.BigInteger
import java.util.*
val TWO: BigInteger = BigInteger.valueOf(2L)
fun main() {
    val scanner = Scanner(System.`in`)
    val max = scanner.nextInt()
    for (i in 1..max) {
        val right = scanner.nextBigInteger()
        val left = scanner.nextBigInteger()
        val count = scanner.nextBigInteger()
        val half = count / TWO
        var result = (right - left) * half

        if (count.mod(TWO) != BigInteger.ZERO) {
            result += right
        }
        println(result)
    }
}