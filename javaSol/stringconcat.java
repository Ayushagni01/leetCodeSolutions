
public class Main
{
	public static void main(String[] args) {
	int aa[]={1,2,3};
	//need to concatinate the two different array ;
	
	
	String a="";

	for(int i=0;i<aa.length;i++)
	{
	    a=a+aa[i]+",";
	}
	
	for(int i=0;i<aa.length;i++)
	{
	    if(i==aa.length-1)
	    {
	        a=a+aa[i]; 
	    }
	    else{
	    a=a+aa[i]+",";
	    }
	}
	String [] ans=a.split(",");
	int ay[]=new int[ans.length];
	for(int i=0;i<ay.length;i++)
	{
	    int au=Integer.parseInt(ans[i]);
	    ay[i]=au;
	}

	
	}
}
