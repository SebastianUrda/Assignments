package Business;
import java.util.Observable;

import AnnotedClasses.SetH;
public class SetBusiness extends Observable {
 
	public static boolean checkIfWon(SetH set)
	{
		if(set.getPp1()>=11&&set.getPp1()>=set.getPp2()+2)
			return true;
		if(set.getPp2()>=11&&set.getPp2()>=set.getPp1()+2)
			return true;
		return false;
	}


}
