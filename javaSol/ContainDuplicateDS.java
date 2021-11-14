package com.easy;
import java.util.*;
public class ContainDuplicateDS {
	
	
	
	
	
	public static boolean containsDuplicate(int[] nums) {
	    if(nums==null || nums.length==0)
	        return false;
	 
	    HashSet<Integer> set = new HashSet<Integer>();
	    for(int i: nums){
	        if(!set.add(i)){
	            return true;
	        }
	    }
	 
	    return false;
	}
	public static void complexityn2(int [] a)
	{
		int count=0;
		boolean k=false;
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				
				if(a[i]==a[j])
				{
					System.out.println("for i "+i+"for j is "+j);
				//	System.out.println("ayush agnihotri");
					count++;
					break;
				}
			}
			if(count>0)
			{
				k=true;
				break;
				
			}
			
			
		}
		if(k)
		{
			System.out.println("this is true");
			
		}else {
			System.out.println("this is false");

		}
		
	}
	
	
	public static void main(String [] args)
	{
		int a[]= {1,3,4,2,1};
		//approach 1 when n2 is complexity
		//complexityn2(a);  //getting time limit exceeds
		
		//better solution approached
	System.out.println(containsDuplicate(a));
		
	}
	
}
