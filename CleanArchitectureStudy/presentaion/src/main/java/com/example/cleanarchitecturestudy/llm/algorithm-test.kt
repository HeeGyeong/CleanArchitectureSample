package com.example.cleanarchitecturestudy.llm

/**
 * 알고리즘 구현 테스트 : 25.04.28 기준 테스트 중 입니다.
 * 
 * 다음 알고리즘 문제들을 구현하세요:
 * 1. 그래프에서 최단 경로 찾기 (다익스트라 알고리즘)
 * 2. 이진 트리 순회 (전위, 중위, 후위)
 * 3. 정렬 알고리즘 구현 및 성능 비교 (퀵소트, 병합정렬, 힙소트)
 */

// 테스트 데이터
val graph = mapOf(
    "A" to mapOf("B" to 5, "C" to 2),
    "B" to mapOf("A" to 5, "C" to 7, "D" to 3),
    "C" to mapOf("A" to 2, "B" to 7, "D" to 10),
    "D" to mapOf("B" to 3, "C" to 10, "E" to 4),
    "E" to mapOf("D" to 4)
)

// 이진 트리 노드 클래스
class TreeNode<T>(
    val value: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null
)

// 예제 이진 트리 생성
val root = TreeNode(1).apply {
    left = TreeNode(2).apply {
        left = TreeNode(4)
        right = TreeNode(5)
    }
    right = TreeNode(3).apply {
        left = TreeNode(6)
        right = TreeNode(7)
    }
}

// 정렬 테스트용 배열
val unsortedArray = intArrayOf(34, 7, 23, 32, 5, 62, 1, 20, 14, 42, 50, 19)

/**
 * 구현해야 할 함수들
 */

/**
 * 1. 다익스트라 알고리즘 구현
 * 그래프와 시작 노드를 입력받아 모든 노드까지의 최단 거리를 반환
 * 
 * @param graph 그래프 객체 (인접 리스트 형태)
 * @param start 시작 노드
 * @return 각 노드까지의 최단 거리 객체
 */
fun dijkstra(graph: Map<String, Map<String, Int>>, start: String): Map<String, Int> {
    // 여기에 구현하세요
    return emptyMap()
}

/**
 * 2-1. 이진 트리 전위 순회 (Pre-order: 노드-왼쪽-오른쪽)
 * 
 * @param root 트리의 루트 노드
 * @return 전위 순회 결과 리스트
 */
fun <T> preOrderTraversal(root: TreeNode<T>?): List<T> {
    // 여기에 구현하세요
    return emptyList()
}

/**
 * 2-2. 이진 트리 중위 순회 (In-order: 왼쪽-노드-오른쪽)
 * 
 * @param root 트리의 루트 노드
 * @return 중위 순회 결과 리스트
 */
fun <T> inOrderTraversal(root: TreeNode<T>?): List<T> {
    // 여기에 구현하세요
    return emptyList()
}

/**
 * 2-3. 이진 트리 후위 순회 (Post-order: 왼쪽-오른쪽-노드)
 * 
 * @param root 트리의 루트 노드
 * @return 후위 순회 결과 리스트
 */
fun <T> postOrderTraversal(root: TreeNode<T>?): List<T> {
    // 여기에 구현하세요
    return emptyList()
}

/**
 * 3-1. 퀵 정렬 구현
 * 
 * @param arr 정렬할 배열
 * @return 정렬된 새 배열
 */
fun quickSort(arr: IntArray): IntArray {
    // 여기에 구현하세요
    return arr.copyOf()
}

/**
 * 3-2. 병합 정렬 구현
 * 
 * @param arr 정렬할 배열
 * @return 정렬된 새 배열
 */
fun mergeSort(arr: IntArray): IntArray {
    // 여기에 구현하세요
    return arr.copyOf()
}

/**
 * 3-3. 힙 정렬 구현
 * 
 * @param arr 정렬할 배열
 * @return 정렬된 새 배열
 */
fun heapSort(arr: IntArray): IntArray {
    // 여기에 구현하세요
    return arr.copyOf()
}

/**
 * 성능 테스트 함수
 */
fun benchmarkSort(sortFn: (IntArray) -> IntArray, array: IntArray): Long {
    val start = System.nanoTime()
    val sorted = sortFn(array.copyOf())
    val end = System.nanoTime()
    
    val durationMs = (end - start) / 1_000_000.0
    println("${sortFn.javaClass.name} 실행 시간: ${durationMs}ms")
    println("정렬 결과: ${sorted.joinToString()}")
    
    return end - start
}

/**
 * 테스트 실행 함수
 */
fun runTests() {
    println("===== 다익스트라 알고리즘 테스트 =====")
    println(dijkstra(graph, "A"))
    
    println("\n===== 이진 트리 순회 테스트 =====")
    println("전위 순회: ${preOrderTraversal(root)}")
    println("중위 순회: ${inOrderTraversal(root)}")
    println("후위 순회: ${postOrderTraversal(root)}")
    
    println("\n===== 정렬 알고리즘 성능 테스트 =====")
    println("원본 배열: ${unsortedArray.joinToString()}")
    
    val quickTime = benchmarkSort(::quickSort, unsortedArray)
    val mergeTime = benchmarkSort(::mergeSort, unsortedArray)
    val heapTime = benchmarkSort(::heapSort, unsortedArray)
    
    println("\n===== 성능 비교 =====")
    println("퀵 정렬: ${quickTime / 1_000_000.0}ms")
    println("병합 정렬: ${mergeTime / 1_000_000.0}ms")
    println("힙 정렬: ${heapTime / 1_000_000.0}ms")
}

// 안드로이드 앱에서 호출하기 위한 유틸리티 클래스
class AlgorithmTest {
    companion object {
        @JvmStatic
        fun testAll() {
            runTests()
        }
        
        @JvmStatic
        fun testDijkstra(startNode: String): Map<String, Int> {
            return dijkstra(graph, startNode)
        }
        
        @JvmStatic
        fun testTreeTraversal(): Triple<List<Int>, List<Int>, List<Int>> {
            return Triple(
                preOrderTraversal(root),
                inOrderTraversal(root),
                postOrderTraversal(root)
            )
        }
        
        @JvmStatic
        fun testSorting(array: IntArray): Triple<IntArray, IntArray, IntArray> {
            return Triple(
                quickSort(array.copyOf()),
                mergeSort(array.copyOf()),
                heapSort(array.copyOf())
            )
        }
    }
} 