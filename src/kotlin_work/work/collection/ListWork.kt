package kotlin_work.collection

val ms = listOf("穂乃果", "絵里", "ことり", "海未", "凛", "真姫", "希", "花陽", "にこ")
val seconds = listOf("穂乃果", "ことり", "海未")

fun main(args: Array<String>) {
	initList()
	println()
	parameters()
	println()
	basicFunction()
	println()
	extensionProperties()
	println()
	extensionFunctions()
}

fun initList() {
	val ms = mutableListOf("穂乃果", "ことり", "海未")
	val first = listOf("花陽", "凛", "真姫")
	val seitokai = listOf("絵里", "希")
	ms.addAll(first)
	ms.add("にこ")
	ms.addAll(seitokai)

	// エラー
//	seitokai.add("にこ")

	println(ms)
	// [穂乃果, ことり, 海未, 花陽, 凛, 真姫, にこ, 絵里, 希]
}

fun parameters() {
	// size Parameters
	println(ms.size)
}

fun basicFunction() {

	// Functios
	// conatins
	println(seconds.contains("穂乃果"))

	// containsAll
	println(seconds.containsAll(listOf("穂乃果", "ことり")))
	println(seconds.containsAll(listOf("穂乃果", "絵里")))

	// get
	println(ms.get(0))
	println(ms[0])

	// indexOf
	val duplicate = listOf("穂乃果", "ことり", "ことり", "海未")
	println(duplicate.indexOf("ことり"))
	println(duplicate.lastIndexOf("ことり"))

	// isEmpty
	val emptyList = listOf<String>()
	println(emptyList.isEmpty())
	println(ms.isEmpty())

	// iterator, listIterator
	val itr = ms.iterator()
	val listItr = ms.listIterator(2)
	println(itr.next())
	println(listItr.previous())

	// subList
	println(ms.subList(0, 3))
}

fun extensionProperties() {
	// indices
	println(ms.indices)

	// lastIndex
	println(ms.lastIndex)
}

fun extensionFunctions() {
	val numberList = listOf(1, 2, 3, 4, 5)

	// all
	println(numberList.all { it < 6 })
	println(numberList.all { it < 5 })

	// any
	println(numberList.any { it > 5 })
	println(numberList.any { it > 4 })

	// asReversed
	println(numberList.asReversed())

	// associate
	val associateMap = mutableMapOf<Int, Int>()
	val associateByMap = mutableMapOf<Int, Int>()
	val associateWithMap = mutableMapOf<Int, Int>()
	println(numberList.associate { it to it * 10 })
	println(numberList.associateBy { it * 10 })
	println(numberList.associateTo(associateMap) { it to it * 100 })
	println(numberList.associateByTo(associateByMap) { it * 100 })
	println(numberList.associateWith { it * 1000 })
	println(numberList.associateWithTo(associateWithMap) { it * 1000 })

	// binarySearch
	println(numberList.binarySearch(2))
	println(numberList.binarySearch(6))
	println(numberList.binarySearch(element = 2, fromIndex = 0, toIndex = 3))
	println(numberList.binarySearch(element = 2, comparator = Comparator { a, b -> a - b }))
	println(numberList.binarySearchBy(2, selector = { it }))

	// chunked
	println(numberList.chunked(2))

	// component
	println(numberList.component1())
	println(numberList.component2())

	// contains
	println(numberList.contains(2))
	println(numberList.contains(6))
	println(numberList.containsAll(listOf(1, 3, 4, 5, 2)))

	// count
	println(numberList.count { it > 3 })

	// distinct
	val distinctList = listOf(1, 1, 2, 3, 4, 4)
	println(distinctList.distinct())
	println(distinctList.distinctBy { it > 2 })

	// drop
	println(numberList.drop(2))
	println(numberList.dropLast(2))
	println(numberList.dropWhile { it < 2 })
	println(numberList.dropLastWhile { it > 2 })

	// elementAt
	println(numberList.elementAt(2))
	println(numberList.elementAtOrElse(6) { 8 })
	println(numberList.elementAtOrNull(6))

	// filter
	val filterList = mutableListOf<Int>()
	val instanceList = listOf(1, "穂乃果", 3.5, true)
	val nullList = listOf(1, null, 3, null)
	println(numberList.filter { it > 3 })
	println(numberList.filterIndexed { idx, num -> num > 2 && idx > 3 })
	numberList.filterIndexedTo(filterList) { idx, num -> num > 2 && idx > 3 }
	println(filterList)
	println(instanceList.filterIsInstance(String::class.java))
	instanceList.filterIsInstanceTo(filterList, Int::class.java)
	println(filterList)
	println(numberList.filterNot { it > 3 })
	println(nullList.filterNotNull())

	// find
	println(numberList.find { it > 2 })
	println(numberList.find { it > 5 })
	println(numberList.findLast { it > 2 })

	// first
	println(numberList.first { it > 2 })
	println(numberList.firstOrNull { it > 5 })

	// flatMap
	val flatMapList = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
	println(flatMapList.flatMap { it.map { num -> num * 10 } })
	println(flatMapList.flatten())

	// fold
	println(numberList.fold("X") { initial, value -> initial + value })
	println(numberList.foldRight("X") { value, initial -> initial + value })

	// forEach
	numberList.forEach { print("${it} ") }
	numberList.forEachIndexed { idx, value -> print("${idx}: ${value} ") }

	// get
	println(numberList.getOrElse(6) { 8 })
	println(numberList.getOrNull(6))

	// groupBy
	println(numberList.groupBy({ if (it % 2 == 0) "偶数" else "奇数" }, { it + 2 }))

	// groupingBy
	println(distinctList.groupingBy { it }.eachCount())

	// ifEmpty
	val emptyList = listOf<String>()
	println(numberList.ifEmpty { 5 })
	println(emptyList.ifEmpty { 5 })

	// indexOf
	println(numberList.indexOf(6))
	println(numberList.indexOfFirst { it % 2 == 0 })
	println(numberList.indexOfLast { it % 2 == 0 })

	// intersect
	val intersectList = listOf(1, 4)
	println(numberList.intersect(intersectList))

	// isNotEmpty, isNullOrEmpty
	val nullObj: List<String>? = null
	println(emptyList.isNotEmpty())
	println(nullObj.isNullOrEmpty())

	// joinTo
	println(numberList.joinTo(StringBuilder()))
	println(numberList.joinToString(
		separator = ".",
		prefix = "{",
		postfix = "}",
		limit = 3,
		truncated = "~",
		transform = { "${it * 2}" }
	))

	// last
	println(numberList.last())
	println(numberList.lastIndexOf(4))
	println(numberList.lastOrNull())
	println(emptyList.lastOrNull())

	// map
	println(numberList.map { it * 2 })
	println(numberList.mapIndexed { idx, value -> idx + value })
	println(nullList.mapNotNull { it?.toString() })

	// maxBy, minBy
	val stringList = listOf("a", "bb", "ccc")
	println(stringList.maxBy { it.length })
	println(stringList.minBy { it.length })
	println(numberList.maxWith(Comparator { a, b -> b - a }))
	println(numberList.minWith(Comparator { a, b -> b - a }))

	// minus
	println(numberList.minus(2))
	println(numberList.minus(listOf(1, 3)))

	// none
	println(numberList.none { it > 5 })

	// partition
	println(numberList.partition { it % 2 == 0 })

	// plus
	println(numberList.plus(2))
	println(numberList.plus(listOf(1, 3)))

	// random
	println(numberList.random())

	// reduce
	println(numberList.reduce({ acc, value ->
		print("${acc} * ${value} = ")
		acc * value
	}))

	// requireNoNulls
	println(numberList.requireNoNulls())
//	println(nullList.requireNoNulls())

	// reversed
	println(numberList.reversed())

	// shuffled
	println(numberList.shuffled())

	// single
	println(numberList.single { it == 2 })
	println(numberList.singleOrNull())

	// slice
	println(numberList.slice(1..2))

	// sort
	val sortList = listOf(1, 5, 4, 3, 2)
	println(sortList.sorted())
	println(sortList.sortedDescending())
	println(sortList.sortedBy { it * -1 })
	println(sortList.sortedWith(Comparator { a, b -> a - b }))

	// subtract
	val subtractList = listOf(2, 3)
	println(numberList.subtract(subtractList))

	// sum
	println(numberList.sum())
	println(numberList.sumBy { it * 10 })

	// take
	println(numberList.take(2))
	println(numberList.takeLast(2))
	println(numberList.takeWhile { it < 4 })

	// union
	val unionList = listOf(3, 4, 5, 6, 7)
	println(numberList.union(unionList))

	// unzip
	val pairList = listOf(Pair(1, "one"), Pair(2, "two"), Pair(3, "three"))
	println(pairList.unzip())

	// windowed
	println(numberList.windowed(size = 2, step = 2, partialWindows = true))

	// withIndex
	numberList.withIndex().forEach { print("${it.index} : ${it.value}, ") }
	println()

	// zip
	val zip1 = listOf(1, 2, 3, 4)
	val zip2 = listOf("one", "two", "three")
	println(zip1.zip(zip2))
	println(zip1.zip(zip2, { a, b -> "${a} = ${b}" }))

	// zipWithNext
	println(numberList.zipWithNext())
	println(numberList.zipWithNext { a, b -> a + b })

}