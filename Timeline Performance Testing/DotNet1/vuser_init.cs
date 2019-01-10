//---------------------------------------------
//Script Title        :
//Script Description  :
//
//
//Recorder Version    : 911
//---------------------------------------------

namespace Script {
    using LoadRunner;
    using Mercury.LoadRunner.DotNetProtocol.Replay;
    using MySql.Data.MySqlClient;
    using System;
    using System.Data;
    using System.Globalization;
    using System.Runtime.Remoting;
    
    
    public partial class VuserClass {
        
        public virtual int vuser_init() {

			String assemblyName_1;
			assemblyName_1 = "PresentationFramework-SystemXml, Version=4.0.0.0, Culture=neutral, Pu" + 
			"blicKeyToken=b77a5c561934e089";
			lr.log("Event 1: Activator.CreateInstance(assemblyName_1, \"MS.Internal.SystemXmlExtension" +
			  "\");");
			ObjectHandle_1 = Activator.CreateInstance(assemblyName_1, "MS.Internal.SystemXmlExtension");

			lr.log("Event 2: ObjectHandle_1.Unwrap();");
			Object_1 = ObjectHandle_1.Unwrap();

			lr.start_transaction("register");

			String connectionString_1;
			connectionString_1 = "server=localhost;port=3306;User Id=root;password=123456;Database=time" + 
			"line;charset=utf8";
			lr.log("Event 3: new MySqlConnection(connectionString_1);");
			MySqlConnection_1 = new MySqlConnection(connectionString_1);

			lr.log("Event 4: MySqlConnection_1.Open();");
			MySqlConnection_1.Open();

			String cmdText_1;
			cmdText_1 = "select * from users where username='"+username+"'";
			lr.log("Event 5: new MySqlCommand(cmdText_1, MySqlConnection_1);");
			MySqlCommand_1 = new MySqlCommand(cmdText_1, MySqlConnection_1);

			lr.log("Event 6: MySqlCommand_1.ExecuteReader();");
			MySqlDataReader_1 = MySqlCommand_1.ExecuteReader();

			lr.log("Event 127: LrReplayUtils.DoDataRead(MySqlDataReader_1, out valueTable_1, true, 0)" +
			  ";");
			LrReplayUtils.DoDataRead(MySqlDataReader_1, out valueTable_1, true, 0);
			DATASET_XML(1);

			lr.log("Event 8: MySqlDataReader_1.Close();");
			MySqlDataReader_1.Close();

//			lr.log("Event 9: MySqlConnection_1.Close();");
//			MySqlConnection_1.Close();
//
//			lr.log("Event 10: MySqlConnection_1.Open();");
//			MySqlConnection_1.Open();

			String cmdText_2;
			cmdText_2 = "insert into users values('"+username+"','"+username+"')";
			lr.log("Event 11: new MySqlCommand(cmdText_2, MySqlConnection_1);");
			MySqlCommand_2 = new MySqlCommand(cmdText_2, MySqlConnection_1);

			lr.log("Event 12: MySqlCommand_2.ExecuteNonQuery();");
			Int32RetVal = MySqlCommand_2.ExecuteNonQuery();

//			lr.log("Event 23: MySqlConnection_1.Close();");
//			MySqlConnection_1.Close();
//
//			String connectionString_2;
//			connectionString_2 = "server=localhost;port=3306;User Id=root;password=123456;Database=time" + 
//			"line;charset=utf8";
//			lr.log("Event 29: new MySqlConnection(connectionString_2);");
//			MySqlConnection_2 = new MySqlConnection(connectionString_2);

			lr.end_transaction("register", lr.AUTO);

			lr.start_transaction("login");

			lr.log("Event 30: MySqlConnection_2.Open();");
//			MySqlConnection_2.Open();

			String cmdText_3;
			cmdText_3 = "select * from users where username='"+username+"' and password='"+username+"'";
			lr.log("Event 31: new MySqlCommand(cmdText_3, MySqlConnection_2);");
			MySqlCommand_3 = new MySqlCommand(cmdText_3, MySqlConnection_1);

			lr.log("Event 32: MySqlCommand_3.ExecuteReader();");
			MySqlDataReader_2 = MySqlCommand_3.ExecuteReader();

			lr.log("Event 128: LrReplayUtils.DoDataRead(MySqlDataReader_2, out valueTable_2, false, 1" +
			  ");");
			LrReplayUtils.DoDataRead(MySqlDataReader_2, out valueTable_2, false, 1);
			DATASET_XML(2);

			lr.log("Event 34: MySqlDataReader_2.Close();");
			MySqlDataReader_2.Close();

//			lr.log("Event 35: MySqlConnection_2.Close();");
//			MySqlConnection_2.Close();

//			String connectionString_3;
//			connectionString_3 = "server=localhost;port=3306;User Id=root;password=123456;Database=time" + 
//			"line;charset=utf8";
//			lr.log("Event 39: new MySqlConnection(connectionString_3);");
//			MySqlConnection_3 = new MySqlConnection(connectionString_3);
//
//			lr.log("Event 40: MySqlConnection_3.Open();");
//			MySqlConnection_3.Open();

			String cmdText_4;
			cmdText_4 = "select * from news,users where news.author=users.username";
			lr.log("Event 41: new MySqlCommand(cmdText_4, MySqlConnection_3);");
			MySqlCommand_4 = new MySqlCommand(cmdText_4, MySqlConnection_1);

			lr.log("Event 42: MySqlCommand_4.ExecuteReader();");
			MySqlDataReader_3 = MySqlCommand_4.ExecuteReader();

			lr.log("Event 129: LrReplayUtils.DoDataRead(MySqlDataReader_3, out valueTable_3, true, 10" +
			  ");");
			LrReplayUtils.DoDataRead(MySqlDataReader_3, out valueTable_3, true, 10);
			DATASET_XML(3);

			lr.log("Event 104: MySqlDataReader_3.Close();");
			MySqlDataReader_3.Close();

//			lr.log("Event 105: MySqlConnection_3.Close();");
//			MySqlConnection_3.Close();
			
			MySqlConnection_1.Close();

			lr.end_transaction("login", lr.AUTO);

            return 0;
        }
    }
}
