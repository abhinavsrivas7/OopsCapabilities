package server;

public interface IBank {	
	static String getIFSC()
	{
		return "ABCD003424";
	}
	
	default String getBranch()
	{
		return "Lucknow,Hazratganj Branch";
	}
}