class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int cases = (int)Math.floor(minutesToTest/minutesToDie);
        double bits = Math.log(buckets)/Math.log(cases+1);
        return (int) Math.ceil(bits);
    }
}