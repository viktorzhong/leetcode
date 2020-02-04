func findMinHeightTrees(n int, edges [][]int) []int {
    if n == 1 {return []int{0}}
    g := make(map[int][]int)
    degrees := make([]int, n)

    for i := 0; i < n; i++ {
        g[i] = make([]int, 0)
    }
    for i := 0; i < len(edges); i++ {
        e := edges[i]
        g[e[0]] = append(g[e[0]], e[1])
        g[e[1]] = append(g[e[1]], e[0])
    }

    leaves := make([]int, 0)
    for i := 0; i < n; i++ {
        degrees[i] = len(g[i])
        if degrees[i] == 1 {
            leaves = append(leaves, i)
        }
    }

    for len(leaves) < n {
        size := len(leaves)
        n -= size
        for i := 0; i < size; i++ {
            leaf := leaves[0]
            for _, v := range g[leaf] {
                degrees[v]--
                if degrees[v] == 1 {
                    leaves = append(leaves, v)
                }
            }
            leaves = leaves[1:]
        }

    }
    return leaves
}