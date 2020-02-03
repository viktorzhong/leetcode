func canFinish(numCourses int, prerequisites [][]int) bool {
    indegrees := make([]int, numCourses)
    graph := make(map[int][]int)

    for i := 0; i < len(prerequisites); i++ {
        pair := prerequisites[i]
        graph[pair[1]] = append(graph[pair[1]], pair[0])
        indegrees[pair[0]]++
    }

    queue := make([]int, 0)
    for i := 0; i < numCourses; i++ {
        if indegrees[i] == 0 {
            queue = append(queue, i)
        }
    }

    cnt := 0
    for len(queue) > 0 {
        course := queue[0]
        cnt++
        size := len(graph[course])
        for i := 0; i < size; i++ {
            pointer := graph[course][i]
            indegrees[pointer]--
            if indegrees[pointer] == 0 {
                queue = append(queue, pointer)
            }
        }

        queue = queue[1:]
    }

    return cnt == numCourses
}