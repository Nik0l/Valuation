package AAR;

import java.util.*;
import java.util.Map.Entry;

import org.mcavallo.opencloud.Cloud;
import org.mcavallo.opencloud.Tag;

import org.xeustechnologies.googleapi.spelling.SpellChecker;
import org.xeustechnologies.googleapi.spelling.SpellResponse;

public class Text_Analysis {
	   public static void countWords(List<String> myWords, TreeMap<String, Integer> dictionary) {

		    for(String s:myWords){

		        if(dictionary.containsKey(s))
		            dictionary.put(s, dictionary.get(s)+1);
		        else
		            dictionary.put(s, 1);
		    }
		}
	   
	   public static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
	        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
	            new Comparator<Map.Entry<K,V>>() {
	                @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
	                    int res = e1.getValue().compareTo(e2.getValue());
	                    return res != 0 ? res : 1; // Special fix to preserve items with equal values
	                }
	            }
	        );
	        sortedEntries.addAll(map.entrySet());
	        return sortedEntries;
	    }
	   
	   public static void MakeWords(List<String> NameList,
			   						List<String> WordList) {
		   String[] arr;
		   System.out.println(NameList.size());
		   for (int i = 0; i < NameList.size(); i++)
		   {
			   String s = NameList.get(i);
			   s = Filter.Token(s);
			   arr = s.split(" ");
			   for (int j = 0; j < arr.length; j++)
			   {			   
				   if (arr[j].length() > 2) {
					   if (Filter.isCyrillic(arr[j]))
						   arr[j] = Filter.makeCyrillic(arr[j]);
					   WordList.add(arr[j]);
				   }
				}
			}
	   }
	   
	   public static void output(List<String> WordList) {
		   System.out.println(WordList.size());
		   for (int i = 0; i < WordList.size(); i++)
		   {
			   System.out.println(WordList.get(i));
		   }
	   }
	   
	   public static void output(SortedSet<Entry<String, Integer>> WordList) {
		   System.out.println(WordList);
	   }
	   public static void Run(List<String> NameList,
			   				  List<String> WordList,
			   				  TreeMap<String,Integer> dictionary) 
	   {
		   MakeWords(NameList, WordList);
		   countWords(WordList, dictionary); 
		   output(WordList);
		   output(Text_Analysis.entriesSortedByValues(dictionary));
	   }
}
