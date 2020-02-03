func findOrder(numCourses int, prerequisites [][]int) []int {
    indegrees := make([]int, numCourses)
    graph := make(map[int][]int)
    res := make([]int, numCourses)

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
        res[cnt] = course
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

    if cnt == numCourses {return res}
    return []int{}
}