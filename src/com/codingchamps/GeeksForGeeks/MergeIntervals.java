package com.codingchamps.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class MergeIntervals {

	public static class Interval {

		int start;
		int end;

		public Interval(int start, int end) {
			this.end = end;
			this.start = start;
		}

		public int getStart() {
			return this.start;
		}

		public int getEnd() {
			return this.end;
		}

		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}
	}

	public static ArrayList<Interval> mergeIntervalsApp1(ArrayList<Interval> ar) {

		Collections.sort(ar, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2){
				return i1.getStart() - i2.getStart();
			}
		});
		boolean visited[] = new boolean[ar.size()];
		ArrayList<Interval> result = new ArrayList<>();

		for (int i = 0; i < ar.size(); i++) {
			for (int j = i + 1; j < ar.size(); j++) {
				if (!visited[j] && (ar.get(i).getStart() <= ar.get(j).getStart())
						&& (ar.get(i).getEnd() >= ar.get(j).getStart())) {
					visited[j] = true;
					visited[i] = true;
					result.add(new Interval(ar.get(i).getStart(), ar.get(j).getEnd()));
				}
			}
			if (!visited[i]) {
				result.add(ar.get(i));
			}
		}
		return result;
	}

    public static void mergeIntervalsApp2(ArrayList<Interval> ar){
		
		Collections.sort(ar, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2){
				return i1.getStart() - i2.getStart();
			}
		});
		
		Stack<Interval> s = new Stack<>();
		
		s.push(ar.get(0));
		for(int i=1;i< ar.size();i++){
			
			Interval top = s.pop();
			if ((top.getStart() <= ar.get(i).getStart())
					&& (top.getEnd() >= ar.get(i).getStart())) {
				s.push(new Interval(top.getStart(), ar.get(i).getEnd()));
			} else {
				s.push(top);
				s.push(ar.get(i));
			}
		}
		
		System.out.println("Merged Interval Approach 2 : " + s);
	}
    
public static ArrayList<Interval> mergeIntervalsApp3(ArrayList<Interval> ar){
		
		Collections.sort(ar, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2){
				return i1.getStart() - i2.getStart();
			}
		});
		
		ArrayList<Interval> result = new ArrayList<>();
		int start = ar.get(0).getStart();
		int end = ar.get(0).getEnd();
		
		for(int i =1;i<ar.size();i++){
			
			if ((start <= ar.get(i).getStart())
					&& (end >= ar.get(i).getStart())) {
				end = Math.max(end,ar.get(i).getEnd());
			} else {
				result.add(new Interval(start, end));	
				start = ar.get(i).getStart();
				end = ar.get(i).getEnd();	
			}
		}
		result.add(new Interval(start, end));	
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> ar = new ArrayList<>();

		ar.add(new Interval(1, 3));
		ar.add(new Interval(2, 5));
		ar.add(new Interval(14, 16));
		ar.add(new Interval(10, 13));
		ar.add(new Interval(6, 13));

		System.out.println(ar);

		ArrayList<Interval> result = mergeIntervalsApp1(ar);

		System.out.println("Merged Interval Approach 1 : " + result);
		
		mergeIntervalsApp2(ar);
		
		ArrayList<Interval> result2 =  mergeIntervalsApp3(ar);		

		System.out.println("Merged Interval Approach 3 : " + result2);

	}

}
