import java.util.*;

public class MergeLists
{
	private List<Integer> list1, list2;

	public MergeLists(List<Integer> list1, List<Integer> list2)
	{
		this.list1 = list1;
		this.list2 = list2;
	}

	public List mergeLists()
	{
		int hold1, hold2;
		List output;

		while(!list1.isEmpty() && !list2.isEmpty())
		{
			hold1 = list1.get(0);
			hold2 = list2.get(0);

			if(hold1 < hold2)
			{
				if(output.indexOf(hold1) == -1)
				{
					output.add(hold1);
				}
				list1.remove(0);
			}

			else if (hold1 > hold2)
			{
				if(output.indexOf(hold2) == -1)
				{
					output.add(hold2);
				}
				list2.remove(0);
			}

			else
			{
				if (output.indexOf(hold1) == -1)
				{
					output.add(hold1);
				}
				list1.remove(0);
				list2.remove(0);
			}
		}

		if(list1.isEmpty() && list2.isEmpty())
		{
			return output;
		}
		else if (list1.isEmpty())
		{
			for(int i = 0; i < list2.size(); i++)
			{
				if(output.indexOf(list2.get(0)) == -1)
				{
					output.add(list2.get(0));
				}
				list2.remove(0);
			}
			return output;
		}
		else
		{
			for(int i = 0; i < list1.size(); i++)
			{
				if(output.indexOf(list1.get(0)) == -1)
				{
					output.add(list1.get(0));
				}
				list1.remove(0);
			}
			return output;
		}

	}

}