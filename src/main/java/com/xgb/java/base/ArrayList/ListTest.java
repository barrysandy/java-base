package com.xgb.java.base.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

public class ListTest {

	/**
	 * һ ��������ת��ArrayList
	 */
	public static void arrayToList() {
		/**
		 * ʹ��Arrays.asList()�������Եõ�һ��ArrayList�����ǵõ����ArrayList��ʵ�Ƕ�����Arrays���е�һ��˽�еľ�̬�ڲ��ࡣ
		 * �������Ȼ��java.util.ArrayListͬ�������ǲ�����ͬһ���ࡣjava.util.Arrays.ArrayList����ʵ����set(), get(), 
		 * contains()�ȷ��������ǲ�û�ж�������������Ԫ�صķ�����Ҳ����˵ͨ��Arrays.asList()�õ���ArrayList�Ĵ�С�ǹ̶��ġ�
		 */
		String[] arr = {"0","1","2","3"}; 
		List list = Arrays.asList(arr);
		
		/**
		 * ����ڿ��������У���õ�һ��������ArrayList����java.util.ArrayList��ʵ����������ͨ�����·�ʽ��
		 */
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arr));
		
		
	}
	
	/**
	 * �����ж�һ�������Ƿ����ĳ��ֵ
	 */
	public static void isContainsStr(String str) {
		
		String[] arr = {"0","1","2","3"}; 
		
		/**
		 * ��Ȼ����ʵ�ֹ��ܣ�����Ч��ȴ�Ƚϵ͡���Ϊ������ѹ��Collection�����У�����Ҫ������Ԫ�ر���һ�飬Ȼ����ʹ�ü�����������������
		 */
		Set<String> set = new HashSet<String>(Arrays.asList(arr));
		boolean flag = set.contains(str);
		System.out.println("Is number flag: " + flag);
		
		/**
		 * ���ж�һ�������Ƿ����ĳ��ֵ��ʱ���Ƽ�ʹ��forѭ����������ʽ����ʹ��Apache Commons������ṩ��ArrayUtils���contains������
		 */
		boolean flag2 = false;
		for(int i = 0;i < arr.length;i ++) {
			if(arr[i].contains(str)) {
				flag2 = true;
			}
		}
		System.out.println("Is number flag2: " + flag2);
		
		/**
		 * Apache Commons������ṩ��ArrayUtils���contains������
		 */
		boolean flag3 = ArrayUtils.contains(arr, str);
		System.out.println("Is number flag3: " + flag3);
		
	}
	
	/**
	 * ������ѭ����ɾ���б��е�Ԫ��
	 */
	public static void deleteEleInArrayByFor() {
		String[] arr = {"0","1","2","3"}; 
		/**
		 * ���ϴ����Ŀ���������ɾ��list������Ԫ�أ����ǽ��ȴû�гɹ���ԭ���Ǻ�
		 * ����һ���ؼ������⣺��һ��Ԫ�ر�ɾ��ʱ���б��Ĵ�С��С�����±�Ҳ����֮�仯��
		 * ���Ե�����Ҫ��һ��ѭ�������±�ɾ�����Ԫ�ص�ʱ������������������Ч��
		 */
		List<String> list = new ArrayList<String>(Arrays.asList(arr));
		for(int i=0;i<list.size();i++){
		    list.remove(i);
		}
		System.out.println(list);
		
		/**
		 * Ҳ��Щ��֪�����ϴ������������������±�任����ġ����ԣ������뵽ʹ����ǿforѭ������ʽ��
		 */
		List<String> list2 = new ArrayList<String>(Arrays.asList(arr));
		for(String s:list2){
		    if(s.equals("a")){
		    	list2.remove(s);
		    }
		}
		
		System.out.println(list2);
		
	}
	
	
	public static void main(String[] args) {
		deleteEleInArrayByFor();
	}

}