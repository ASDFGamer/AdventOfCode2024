package de.asdfgamer.aoc2024

class Day3 : AbstractDay() {
    override fun part1(): String {
        var result = 0
        val regex = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)")
        for (line in input) {
            val results =
                regex.findAll(line).map {
                    it.groups[1]!!.value.toInt() * it.groups[2]!!.value.toInt()
                }.sum()
            result += results
        }
        return result.toString()
    }

    override fun part2(): String {
        var result = 0
        val regex = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)|do\\(\\)|don't\\(\\)")
        var enabled = true
        for (line in input) {
            val results =
                regex.findAll(line).map { matchResult ->
                    if (matchResult.value == "do()") {
                        enabled = true
                    } else if (matchResult.value == "don't()") {
                        enabled = false
                    } else if (enabled) {
                        //println(" mul")
                        return@map matchResult.groups[1]!!.value.toInt() * matchResult.groups[2]!!.value.toInt()
                    }
                    return@map 0
                }.sum()
            result += results
        }
        return result.toString()

    }


    fun part2NotWorking(): String {
        var result = 0
        val mulRegex = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)")
        val doRegex = Regex("^|do\\(\\)")
        val dontRegex = Regex("don't\\(\\)")
        for (line in input) {
            val doStarts = doRegex.findAll(line).map { it.range.first }
            val dontStarts = dontRegex.findAll(line).map { it.range.first }
            val results =
                mulRegex.findAll(line).map { matchResult ->
                    val start = matchResult.range.first
                    val lastDo = doStarts.filter { it <= start }.last()
                    val lastDont: Int = try {
                        dontStarts.filter { it < start }.last()
                    } catch (e: NoSuchElementException) {
                        -1
                    }
                    print("pos: $start,  lastDo: $lastDo, lastDont: $lastDont")
                    if (lastDo > lastDont) {
                        println(" mul")
                        return@map matchResult.groups[1]!!.value.toInt() * matchResult.groups[2]!!.value.toInt()
                    } else {
                        println()
                        return@map 0
                    }
                }.sum()
            result += results
        }
        return result.toString()
    }
}
