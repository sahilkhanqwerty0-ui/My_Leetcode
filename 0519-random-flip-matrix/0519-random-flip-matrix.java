class Solution {
    int n, total, size;
    Random rand = new Random();
    HashMap<Integer, Integer> map = new HashMap<>();

    public Solution(int m, int n) {
        this.n = n;
        total = size = m * n;
    }

    public int[] flip() {
        int x = rand.nextInt(total--);
        int idx = map.getOrDefault(x, x);
        map.put(x, map.getOrDefault(total, total));
        return new int[]{idx / n, idx % n};
    }

    public void reset() {
        total = size;
        map.clear();
    }
}