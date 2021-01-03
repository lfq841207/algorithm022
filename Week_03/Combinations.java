class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n < k) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        op(n, k, 1, path, result);
        return result;
    }

    private void op (int n, int k, int idx, Deque<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = idx; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            op(n, k, i + 1, path, result);
            path.removeLast();
        }
    }
}