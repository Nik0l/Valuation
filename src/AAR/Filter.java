package AAR;

public class Filter {
	static int LevenshteinDistance(String s, String t)
	{
	    // degenerate cases
	    if (s == t) return 0;
	    if (s.length() == 0) return t.length();
	    if (t.length() == 0) return s.length();
	 
	    // create two work vectors of integer distances
	    int[] v0 = new int[t.length() + 1];
	    int[] v1 = new int[t.length() + 1];
	 
	    // initialize v0 (the previous row of distances)
	    // this row is A[0][i]: edit distance for an empty s
	    // the distance is just the number of characters to delete from t
	    for (int i = 0; i < v0.length; i++)
	        v0[i] = i;
	 
	    for (int i = 0; i < s.length(); i++)
	    {
	        // calculate v1 (current row distances) from the previous row v0
	 
	        // first element of v1 is A[i+1][0]
	        //   edit distance is delete (i+1) chars from s to match empty t
	        v1[0] = i + 1;
	 
	        // use formula to fill in the rest of the row
	        for (int j = 0; j < t.length(); j++)
	        {
	            int cost; 
	            if (s.charAt(i) == t.charAt(j))
	            	cost = 0;
	            else
	            	cost = 1;
	            v1[j + 1] = Minimum(v1[j] + 1, v0[j + 1] + 1, v0[j] + cost);
	        }
	 
	        // copy v1 (current row) to v0 (previous row) for next iteration
	        for (int j = 0; j < v0.length; j++)
	            v0[j] = v1[j];
	    }
	 
	    return v1[t.length()];
	}
	static int Minimum(int a, int b) {
		if (a>=b)
			return b;
		else 
			return a;
	}
	
	static int Minimum(int a, int b, int c) {
		int temp = Minimum(a,b);
		return Minimum(temp, c);
	}
	static String DeleteNumbers(String s) {
		String s1 = s.replaceAll("[0-9!@#$%^&*()><?=|№]", "");
		s1 = s1.replaceAll("'", ""); 
		s1 = s1.replaceAll("\"", ""); 
		s1 = s1.replaceAll("\\+", ""); 
		s1 = s1.replaceAll("\\\\", ""); 
		s1 = s1.toLowerCase();
		if ((s1 == " ") || (s1 == "  ") || (s1 == "   ") || (s1 == "    "))
			s1 = "";
		if (s1.length() == 1)
			s1 = "";
		return s1;
	}
	static String Token(String s) {
		String s1 = s.replaceAll("[,.:;-]", " ");
		s1 = s1.replaceAll("\\/", " ");
		s1 = s1.replaceAll("-", " ");
		return s1;
	}
	
	static boolean isCyrillic(char c) {
		return
		Character.UnicodeBlock.CYRILLIC.equals(Character.UnicodeBlock.of(c));
	}
	
	static boolean isCyrillic(String s) {
		int latin = 0;
		int cyrillic = 0;
		for (int i = 0; i < s.length(); i++) {
			if (isCyrillic(s.charAt(i)))
				cyrillic++;
			else
				latin++;						
		}
		if (cyrillic > 0)
			return true;
		else
			return false;
	}
	
	static String makeCyrillic(String s) {
		String s1;
		s1 = s.replaceAll("a", "а");
		s1 = s1.replaceAll("b", "в");
		s1 = s1.replaceAll("c", "с");
		s1 = s1.replaceAll("e", "е");
		s1 = s1.replaceAll("h", "н");
		s1 = s1.replaceAll("k", "к");
		s1 = s1.replaceAll("m", "м");
		s1 = s1.replaceAll("o", "о");
		s1 = s1.replaceAll("p", "р");
		s1 = s1.replaceAll("t", "т");
		s1 = s1.replaceAll("x", "х");
		s1 = s1.replaceAll("y", "у");
		s1 = s1.replaceAll("u", "и");
		return s1;
	}
	
	
}
