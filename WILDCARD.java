import java.util.Scanner;
import java.util.Arrays;

public class WILDCARD {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
	
		int c;
		String w;
		
		c = sc.nextInt();
		
		for(int i = 0 ; i < c; i++)
		{
			boolean ret;
			
			w = sc.next();
			
			int n = sc.nextInt();
			
			String[] result = new String[n];
			
			int r_pos = 0;
			
			for(int j = 0; j < n; j++)
			{
				String s = sc.next();
				
				ret = match(w, s, 0, 0);
				
				if(ret)
				{
					result[r_pos++] = s;
				}
			}
			
			Arrays.sort(result, 0, r_pos);
			
			for(int j = 0; j < r_pos; j++)
			{
				System.out.println(result[j]);
			}
		}
	}
	
	public static boolean match(String w, String s, int w_pos, int s_pos)
	{
		if(w_pos < w.length() && s_pos < s.length() && ( w.charAt(w_pos) == '?' || w.charAt(w_pos) == s.charAt(s_pos) ) )
		{
			return match(w, s, w_pos + 1, s_pos + 1);
		}
		
		if(w_pos == w.length()) return ( s_pos == s.length() ); 
		
		if(w.charAt(w_pos) == '*')
		{
			if(match(w, s, w_pos + 1, s_pos) || ( s_pos < s.length() && match(w, s, w_pos, s_pos + 1) ) ) 
			{
				return true;				
			}
		}
		
		return false;
	}
	 
}