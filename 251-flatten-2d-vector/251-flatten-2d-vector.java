class Vector2D {

    ArrayList<Integer> values;
    int counter;
    public Vector2D(int[][] vec) {
        values = new ArrayList<>();
        counter = 0;
        for(int v[] : vec){
            for(int x : v)
            values.add(x);
        }
    }
    
    public int next() {
        return values.get(counter++);
    }
    
    public boolean hasNext() {
        return counter<values.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */