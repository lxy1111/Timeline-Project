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
        
        public virtual int Action() {

    		lr.rendezvous("send_message");
    		
    		String connectionString_3;
			connectionString_3 = "server=localhost;port=3306;User Id=root;password=123456;Database=time" + 
			"line;charset=utf8";
			lr.log("Event 39: new MySqlConnection(connectionString_3);");
			MySqlConnection_3 = new MySqlConnection(connectionString_3);

			lr.log("Event 40: MySqlConnection_3.Open();");
			MySqlConnection_3.Open();
    		
			String assemblyName_1;
			assemblyName_1 = "PresentationFramework-SystemXml, Version=4.0.0.0, Culture=neutral, Pu" + 
			"blicKeyToken=b77a5c561934e089";
			lr.log("Event 1: Activator.CreateInstance(assemblyName_1, \"MS.Internal.SystemXmlExtension" +
			  "\");");
			ObjectHandle_1 = Activator.CreateInstance(assemblyName_1, "MS.Internal.SystemXmlExtension");

			lr.log("Event 2: ObjectHandle_1.Unwrap();");
			Object_1 = ObjectHandle_1.Unwrap();

			lr.start_transaction("send_message");

			String connectionString_2;
			connectionString_2 = "server=localhost;port=3306;User Id=root;password=123456;Database=time" + 
			"line;charset=utf8";
			lr.log("Event 110: new MySqlConnection(connectionString_2);");
			MySqlConnection_3 = new MySqlConnection(connectionString_2);

			lr.log("Event 111: MySqlConnection_3.Open();");
			MySqlConnection_3.Open();

			string message = "testmessage by "+username;
			string imageUrl = "C:\\\\Users\\\\xsk\\\\Pictures\\\\pic.jpg";
			DateTime now = DateTime.Now;
            string nowtime = now.GetDateTimeFormats('f')[0].ToString();
			String cmdText_3;
            cmdText_3 = "insert into news (`content`, `imageURL`, `author`, `posttime`) values('"+message+"','"+imageUrl+"','"+username+"','"+nowtime+"')";
			lr.log("Event 114: new MySqlCommand(cmdText_3, MySqlConnection_3);");
			MySqlCommand_5 = new MySqlCommand(cmdText_3, MySqlConnection_3);

			lr.log("Event 113: MySqlCommand_3.ExecuteNonQuery();");
			Int32RetVal = MySqlCommand_5.ExecuteNonQuery();

//			lr.log("Event 114: MySqlConnection_3.Close();");
//			MySqlConnection_3.Close();
			
			lr.end_transaction("send_message", lr.AUTO);

			lr.start_transaction("refresh_message");

//			lr.log("Event 117: MySqlConnection_2.Open();");
//			MySqlConnection_2.Open();

			String cmdText_4;
			cmdText_4 = "select * from news,users where news.author=users.username";
			lr.log("Event 118: new MySqlCommand(cmdText_4, MySqlConnection_2);");
			MySqlCommand_4 = new MySqlCommand(cmdText_4, MySqlConnection_3);

			lr.log("Event 119: MySqlCommand_4.ExecuteReader();");
			MySqlDataReader_3 = MySqlCommand_4.ExecuteReader();

			lr.log("Event 416: LrReplayUtils.DoDataRead(MySqlDataReader_3, out valueTable_3, true, 11" +
			  ");");
			LrReplayUtils.DoDataRead(MySqlDataReader_3, out valueTable_3, true, 11);
			DATASET_XML(3);

			lr.log("Event 187: MySqlDataReader_3.Close();");
			MySqlDataReader_3.Close();

//			lr.log("Event 188: MySqlConnection_2.Close();");
//			MySqlConnection_2.Close();

			lr.end_transaction("refresh_message", lr.AUTO);

			lr.start_transaction("more_message");

//			lr.log("Event 192: MySqlConnection_2.Open();");
//			MySqlConnection_2.Open();

			String cmdText_5;
			cmdText_5 = "select * from news,users where news.author=users.username";
			lr.log("Event 193: new MySqlCommand(cmdText_5, MySqlConnection_2);");
			MySqlCommand_5 = new MySqlCommand(cmdText_5, MySqlConnection_3);

			lr.log("Event 194: MySqlCommand_5.ExecuteReader();");
			MySqlDataReader_4 = MySqlCommand_5.ExecuteReader();

			lr.log("Event 417: LrReplayUtils.DoDataRead(MySqlDataReader_4, out valueTable_4, true, 11" +
			  ");");
			LrReplayUtils.DoDataRead(MySqlDataReader_4, out valueTable_4, true, 11);
			DATASET_XML(4);

			lr.log("Event 262: MySqlDataReader_4.Close();");
			MySqlDataReader_4.Close();

//			lr.log("Event 263: MySqlConnection_2.Close();");
//			MySqlConnection_2.Close();
			
			MySqlConnection_3.Close();

			lr.end_transaction("more_message", lr.AUTO);

            return 0;
        }
    }
}
