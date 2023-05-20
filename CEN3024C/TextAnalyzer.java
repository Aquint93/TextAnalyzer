
package CEN3024C;
import java.io.*;
import java.util.*;


public class TextAnalyzer {
	

	public static void main(String[] args) throws IOException {
		File file = new File("raven.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		Map<String, Integer> wordFrequency = new HashMap<>();
		
		String line = br.readLine();
		while(line != null) {
						
			if(!line.trim().equals("")) {
				String [] words = line.toLowerCase().split(" ");
				
				for(String word : words) {
					if(word == null || word.trim().equals("")) {
						continue;
					}
					
					String str = word.replaceAll("[^a-z]", "");
					
					if(wordFrequency.containsKey(str)) {
						wordFrequency.put(str, wordFrequency.get(str)+1);
					} else {
						wordFrequency.put(str, 1);
					}
				}
			}
			
			line = br.readLine();
		}
		br.close();
		
		Set<Map.Entry<String, Integer>> set = wordFrequency.entrySet();
		List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set);
		
		Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>(){
			public int compare(Map.Entry<String, Integer>a, Map.Entry<String, Integer>b) {
				return(b.getValue()).compareTo(a.getValue());
			}
		});
		for(Map.Entry<String, Integer> i: sortedList) {
				System.out.println(i.getKey()+" = "+i.getValue());
		}
	}

}