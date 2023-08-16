package practice;

public class DemoTwo 
{
	public static void main(String[] args) 
	{
		String st="Prashant";


		for(int i=0;i<st.length();i++)
		{
			int count=1;
			for(int j=i+1;j<st.length();j++)
			{
				if(st.charAt(j)==st.charAt(i))
				{
					count++;
				
				}
			}
			System.out.println("The count of "+ st.charAt(i)+" is "+count);
		}
	}
}
