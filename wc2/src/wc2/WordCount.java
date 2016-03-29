package wc2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class WordCount {
	public static int words=0;
	public static int lines=1;
	public static int chars=0;
	public static void wc(InputStream f)throws IOException{
		int c=0;
		boolean lastnotwhite =false;
		String whitespace="\t\n\r";
		while((c=f.read()) != -1){
			chars++;
			if(c=='\n')
				lines++;
			if(whitespace.indexOf(c)!=-1){
				if(lastnotwhite){
					words++;
				}
				lastnotwhite=false;
			}else{
				lastnotwhite=true;
			}
		}
	}
	public static void main(String args[]){
		FileInputStream f;
		 Scanner s = new Scanner(System.in);
		 String str = null;
		 System.out.println("please input file location");
		 str = s.next();
		try{
			if(args.length==0){
				f=new FileInputStream(str);
				wc(f);
			}else{
				for(int i=0;i<args.length;i++){
					f=new FileInputStream(args[i]);
					wc(f);
				}
			}
		}catch(IOException e){
			return;
		}
		System.out.println("line:"+lines+";word:"+words+";char:"+chars);
	}
}

