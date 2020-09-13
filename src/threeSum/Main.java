package threeSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	//Comentario mas extendido desde pc (corregido)
	
	/* 
	 * Returns unique lists of a, b, c numbers so that a + b + c = 0
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> set = new HashSet<List<Integer>>();		/*Set where lists are stored. Since it's a set, these are unique lists*/
		List<List<Integer>> list = new LinkedList<List<Integer>>(); /*By the end of the code, all lists are moved from the set to here
		 															  since it has to match the return type*/
        if (nums == null || nums.length < 3) return list;
        Arrays.sort(nums); /*O(n*log n)*/
        int index = 1, left, right, len = nums.length, result;
        while (index < len) {
        	left = index - 1;
        	right = index + 1;
        	while (left >= 0 && right < len) {
        		result = nums[index] + nums[left] + nums[right];
        		if (result == 0) {
        			set.add(Arrays.asList(nums[left],nums[index],nums[right]));
        			right++;
        			left--;
        		}
        		else if (result > 0) left--;
        		else right++;
        	}
        	index++;
        }
        list.addAll(set);
        return list;
    }
	
	/*
	 * Returns the sum of 3 numbers from nums which is the closest to target
	 */
	public static int threeSumClosest(int[] nums, int target) {
        int sum = -100001, prev = -100002, len = nums.length, index = 1, right, left;
        Arrays.sort(nums);
        while (index < len && sum != target) {
        	right = index + 1;
        	left = index - 1;
        	while (left >= 0 && right < len && sum != target) {
        		sum = nums[left] + nums[index] + nums[right];
        		if (Math.abs(target - sum) < Math.abs(target - prev)) prev = sum;
        		if (sum > target) left--;
        		else right++;
        	}
        	index++;
        }
        return prev;
    }
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		if (nums == null || nums.length < 4) return list;
		int mid1 = nums.length/2-1, mid2 = mid1+1, leftLimit = mid1 - 1, rightLimit = mid2 + 1,
			auxLeftLimit = leftLimit, auxRightLimit = rightLimit;
		boolean moveLeftLimit = true, moveRightLimit = false;
		Arrays.sort(nums);
		while (auxLeftLimit >= 0 || auxRightLimit < nums.length) {
			kSum(nums,leftLimit,rightLimit,-nums[leftLimit]-nums[rightLimit],set);
			if (moveLeftLimit) {
				if (leftLimit-1 >= 0) leftLimit--;
				else {
					moveLeftLimit = false;
					leftLimit = auxLeftLimit;
					moveRightLimit = true;
				}
			}
			else if (moveRightLimit && rightLimit+1 < nums.length) rightLimit++;
			else {
				leftLimit = --auxLeftLimit;
				rightLimit = ++auxRightLimit;
				moveLeftLimit = true;
				moveRightLimit = false;
			}
		}
		list.addAll(set);
		return list;
	}

	private static void kSum(int[] nums, int leftLimit, int rightLimit, int target, HashSet<List<Integer>> set) {
		int mid1 = (rightLimit+leftLimit)/2, mid2 = mid1+1, result;
		while (mid1 > leftLimit && mid2 < rightLimit) {
			result = nums[mid1] + nums[mid2];
			if (result == target) {
				set.add(Arrays.asList(nums[leftLimit],nums[mid1],nums[mid2],nums[rightLimit]));
				mid1--;
				mid2++;
			}
			else if (result > target) mid1--;
			else mid2++;
		}
		int aux = mid2, aux2 = mid1, limit = rightLimit;
		if (mid1 > leftLimit) {
			aux = mid1;
			aux2 = mid2;
			limit = leftLimit;
		}
		while (aux != limit) {
			result = nums[aux] + nums[aux2];
			if (result == target) set.add(Arrays.asList(nums[leftLimit],nums[aux],nums[aux2],nums[rightLimit]));
			else if (result > target) aux--;
			else aux++;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Length of array: ");
		int len = scan.nextInt();
		int[] array = new int[len];
		for(int i = 0; i < len; i++) {
			System.out.print("array["+ (i+1) +"] = ");
			array[i] = scan.nextInt();
		}
		System.out.print("Target: ");
		int target = scan.nextInt();
		scan.close();
		List<List<Integer>> list = fourSum(array,target);
		len = list.size();
		for(int i = 0; i < len; i++) System.out.println(list.get(i).toString());

	}

}
