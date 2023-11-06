class lettersCollection
{
    static List<Integer> matrixSum(int n, int m, int mat[][], int q, int queries[][])
    {
 
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int ind = queries[i][0], x = queries[i][1], y = queries[i][2];
            l.add(solve(ind, n, m, mat, x, y));
        }

        return l;
    }

    static int solve(int ind, int n, int m, int mat[][], int r, int c) {
        int sum = 0;

        if (ind == 1) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nx = r + i, ny = c + j;
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m)
                        sum += mat[nx][ny];
                }
            }

            sum -= mat[r][c];
        } else {
            int dx[] = {-2, -2, -2, -2, -2, -1, 0, 1, 2, 2, 2, 2, 2, 1, 0, -1};
            int dy[] = {-2, -1, 0, 1, 2, 2, 2, 2, 2, 1, 0, -1, -2, -2, -2, -2};

            for (int i = 0; i < 16; i++) {
                int nx = r + dx[i], ny = c + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m)
                    sum += mat[nx][ny];
            }
        }

        return sum;
    }
}