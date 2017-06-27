package com.canauhtli.cfdi;

import com.canauhtli.cfdi.db.DBManager;
import com.canauhtli.config.ConfigManager;
import com.canauhtli.utils.ClienteSMTP;

public class InitMail {

	public static void main(String[] args) {
		DBManager dbm = new DBManager();
		ConfigManager cm = new ConfigManager(dbm);
		ClienteSMTP smtp = new ClienteSMTP(cm);

	}

}
