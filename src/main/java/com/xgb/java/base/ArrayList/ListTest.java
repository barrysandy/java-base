package com.xgb.java.base.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

public class ListTest {

	/**
	 * 一 、把数组转成ArrayList
	 */
	public static void arrayToList() {
		/**
		 * 使用Arrays.asList()方法可以得到一个ArrayList，但是得到这个ArrayList其实是定义在Arrays类中的一个私有的静态内部类。
		 * 这个类虽然和java.util.ArrayList同名，但是并不是同一个类。java.util.Arrays.ArrayList类中实现了set(), get(), 
		 * contains()等方法，但是并没有定义向其中增加元素的方法。也就是说通过Arrays.asList()得到的ArrayList的大小是固定的。
		 */
		String[] arr = {"0","1","2","3"}; 
		List list = Arrays.asList(arr);
		
		/**
		 * 如果在开发过程中，想得到一个真正的ArrayList对象（java.util.ArrayList的实例），可以通过以下方式：
		 */
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arr));
		
	}
	
	/**
	 * 二、判断一个数组是否包含某个值
	 */
	public static void isContainsStr(String str) {
		
		String[] arr = {"0","1","2","3"}; 
		
		/**
		 * 虽然可以实现功能，但是效率却比较低。因为将数组压入Collection类型中，首先要将数组元素遍历一遍，然后再使用集合类做其他操作。
		 */
		Set<String> set = new HashSet<String>(Arrays.asList(arr));
		boolean flag = set.contains(str);
		System.out.println("Is number flag: " + flag);
		
		/**
		 * 在判断一个数组是否包含某个值的时候，推荐使用for循环遍历的形式或者使用Apache Commons类库中提供的ArrayUtils类的contains方法。
		 */
		boolean flag2 = false;
		for(int i = 0;i < arr.length;i ++) {
			if(arr[i].contains(str)) {
				flag2 = true;
			}
		}
		System.out.println("Is number flag2: " + flag2);
		
		/**
		 * Apache Commons类库中提供的ArrayUtils类的contains方法。
		 */
		boolean flag3 = ArrayUtils.contains(arr, str);
		System.out.println("Is number flag3: " + flag3);
		
	}
	
	/**
	 * 三、在循环中删除列表中的元素
	 */
	public static void deleteEleInArrayByFor() {
		String[] arr = {"0","1","2","3"}; 
		/**
		 * 以上代码的目的是想遍历删除list中所有元素，但是结果却没有成功。原因是忽
		 * 略了一个关键的问题：当一个元素被删除时，列表的大小缩小并且下标也会随之变化，
		 * 所以当你想要在一个循环中用下标删除多个元素的时候，它并不会正常的生效。
		 */
		List<String> list = new ArrayList<String>(Arrays.asList(arr));
		for(int i=0;i<list.size();i++){
		    list.remove(i);
		}
		System.out.println(list);
		
		/**
		 * 也有些人知道以上代码的问题就由于数组下标变换引起的。所以，他们想到使用增强for循环的形式：
		 */
		List<String> list2 = new ArrayList<String>(Arrays.asList(arr));
		for(String s:list2){
		    if(s.equals("a")){
		    	list2.remove(s);
		    }
		}
		
		System.out.println(list2);
		
	}
	
	
	/**
	 * 四、HashTable 和 HashMap 的选择
	 * 了解算法的人可能对HashTable比较熟悉，因为他是一个数据结构的名字。但在Java里边，用HashMap来表示这样的数据结构。
	 * Hashtable和 HashMap的一个关键性的不同是，HashTable是同步的，而HashMap不是。所以通常不需要HashTable，HashMap用的更多。
	 */
	public static void hashMapAndTable(){
		
	}
	
	
	/**
	 * 五、使用原始集合类型
	 * 使用原始集合类型是很危险的，因为原始集合类型跳过了泛型类型检查，是不安全的。Set、Set< ? >和Set< Object >之间有很大差别。
	 */
	
	/**
	 * 六、访问级别
	 * 程序员们经常使用public作为类中的字段的修饰符，因为这样可以很简单的通过引用得到值，但这并不是好的设计，按照经验，分配给成员变量的访问级别应该尽可能的低。
	 */
	
	/**
	 * 七、ArrayList与LinkedList的选择
	 * 当程序员们不知道ArrayList与LinkedList的区别时，他们经常使用ArrayList，因为它看起来比较熟悉。然而，它们之前有巨大的性能差别。
	 * 在ArrayList vs LinkedList vs Vector 区别、Java中常见亲属比较等文章中介绍过，简而言之，如果有大量的增加删除操作并且没有很多的随机访问元素的操作，
	 * 应该首先LinkedList。（LinkedList更适合从中间插入或者删除（链表的特性））
	 */
	
	public static void linkedListTest(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("hello ");
		linkedList.add("linkedList ");
		linkedList.add("is ");
		linkedList.add("List ");
		System.out.println("LinkedList : " + linkedList.size());
	}
	
	
	
	public static void main(String[] args) {
		linkedListTest();
	}

}
