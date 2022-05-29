/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

public class Pair{
    public int importance;
    public List<Integer> subordinates;
    public Pair(){
        
    }
    public Pair(int imp, List<Integer> sub){
        importance = imp;
        subordinates = sub;
    }
}
class Solution {
    int ans = 0;
    public void helper(int src, Map<Integer,Pair> map, int imp){
        ans+=imp;
        if(map.get(src).subordinates.isEmpty())
            return;
        for(int v : map.get(src).subordinates){
            helper(v,map,map.get(v).importance);
        }
    }
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Pair> map = new HashMap<>();
        for(int i=0;i<employees.size();i++){
            map.putIfAbsent(employees.get(i).id,new Pair());
            map.put(employees.get(i).id, new Pair(employees.get(i).importance, employees.get(i).subordinates));
        }
        
        helper(id,map,map.get(id).importance);
        return ans;
    }
}