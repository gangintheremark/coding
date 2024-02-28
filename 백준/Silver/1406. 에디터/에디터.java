import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Arrays;

//1406번
public class Main {

	public static void main(String[] args) throws IOException{
		
		//1 LinkedList와 listIterator 로 구현
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//ArrayList는 삭체 추가시 하나씩 밀려나서 성능저하 위험
		//데이터 삽입 삭제 자주라면 LinkedList
		LinkedList<String> origin = new LinkedList<String>();
		String b[] = br.readLine().split("");
		
		for(String s:b) {
			origin.add(s);
		}
		
		int n = Integer.parseInt(br.readLine());
		
		//리스트를 양방향으로 탐색하는 listIterator
		ListIterator<String> iter = origin.listIterator();
		//커서 초기화 : 맨 뒤
		while(iter.hasNext()) {
			iter.next();
		}
		
		while(n-- >0) {
			String command[] = br.readLine().split(" ");
			String firstCommand= command[0];
			
			
				if(firstCommand.equals("P")) 
				{
					iter.add(command[1]);
				}
				else if(firstCommand.equals("L")) 
				{
					if(iter.hasPrevious()) iter.previous();
				}
				else if(firstCommand.equals("D")) 
				{
					if(iter.hasNext()) iter.next();
				}
				else if(firstCommand.equals("B")) 
				{
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
				}
		}
		System.out.println(String.join("", origin));
  	}
}