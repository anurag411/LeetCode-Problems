class StockSpanner {

    Stack<int []> stack;
    public StockSpanner() {
       stack = new Stack<>(); 
    }
    
    public int next(int price) {
        int count =1;
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            count = count+ stack.peek()[1];
            stack.pop();
        }
        stack.push(new int[]{price, count});
        return count;
    }
}
