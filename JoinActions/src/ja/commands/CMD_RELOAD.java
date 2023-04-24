package ja.commands;

import ja.support.SupportData;

public class CMD_RELOAD
{
	 private static SupportData sdo = new SupportData();
	 
	 public static void command()
	 {
		 sdo.ReloadConfig();
		 sdo.ReloadItems();
     }
}