package com.iu.base;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		for(int i=0;i<a.length();i++) {
			String sb = a.substring(i, i++);
			System.out.println(sb);
			
		}
		
		
	}
	public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums) {
        	if(!list.contains(num)) {
        		list.add(num);
        	}
        }
        answer = list.size();
        return answer;
    }

}
