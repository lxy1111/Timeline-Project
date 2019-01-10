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

			String assemblyName_1;
			assemblyName_1 = "PresentationFramework-SystemXml, Version=4.0.0.0, Culture=neutral, Pu" + 
			"blicKeyToken=b77a5c561934e089";
			lr.log("Event 1: Activator.CreateInstance(assemblyName_1, \"MS.Internal.SystemXmlExtension" +
			  "\");");
			ObjectHandle_1 = Activator.CreateInstance(assemblyName_1, "MS.Internal.SystemXmlExtension");

			lr.log("Event 2: ObjectHandle_1.Unwrap();");
			Object_1 = ObjectHandle_1.Unwrap();

			lr.think_time(16);

			lr.start_transaction("login");

			#warning:  Code Generation Error
			// Found an undefined object of type MySql.Data.MySqlClient.MySqlConnection. Assigning it the name MySqlConnection_1.
			// Suggested solution: adding both this type, in assembly MySql.Data, Version=8.0.13.0, Culture=neutral, PublicKeyToken=c5687fc88969c44d, to the filter 
			// and/or any other types that return instances of this one.
			// Note:  This script will not compile as is.
			lr.log("Event 3: MySqlConnection_1.Open();");
			MySqlConnection_1.Open();

			String cmdText_1;
			cmdText_1 = "select * from users where username='test' and password='test'";
			lr.log("Event 4: new MySqlCommand(cmdText_1, MySqlConnection_1);");
			MySqlCommand_1 = new MySqlCommand(cmdText_1, MySqlConnection_1);

			lr.log("Event 5: MySqlCommand_1.ExecuteReader();");
			MySqlDataReader_1 = MySqlCommand_1.ExecuteReader();

			lr.log("Event 414: LrReplayUtils.DoDataRead(MySqlDataReader_1, out valueTable_1, false, 1" +
			  ");");
			LrReplayUtils.DoDataRead(MySqlDataReader_1, out valueTable_1, false, 1);
			DATASET_XML(1);

			lr.log("Event 7: MySqlDataReader_1.Close();");
			MySqlDataReader_1.Close();

			lr.log("Event 8: MySqlConnection_1.Close();");
			MySqlConnection_1.Close();

			String connectionString_1;
			connectionString_1 = "server=localhost;port=3306;User Id=root;password=123456;Database=time" + 
			"line;charset=utf8";
			lr.log("Event 9: new MySqlConnection(connectionString_1);");
			MySqlConnection_2 = new MySqlConnection(connectionString_1);

			lr.log("Event 10: MySqlConnection_2.Open();");
			MySqlConnection_2.Open();

			String cmdText_2;
			cmdText_2 = "select * from news,users where news.author=users.username";
			lr.log("Event 11: new MySqlCommand(cmdText_2, MySqlConnection_2);");
			MySqlCommand_2 = new MySqlCommand(cmdText_2, MySqlConnection_2);

			lr.log("Event 12: MySqlCommand_2.ExecuteReader();");
			MySqlDataReader_2 = MySqlCommand_2.ExecuteReader();

			lr.log("Event 415: LrReplayUtils.DoDataRead(MySqlDataReader_2, out valueTable_2, true, 10" +
			  ");");
			LrReplayUtils.DoDataRead(MySqlDataReader_2, out valueTable_2, true, 10);
			DATASET_XML(2);

			lr.log("Event 74: MySqlDataReader_2.Close();");
			MySqlDataReader_2.Close();

			lr.log("Event 75: MySqlConnection_2.Close();");
			MySqlConnection_2.Close();

			String assemblyName_2;
			assemblyName_2 = "PresentationFramework-SystemData, Version=4.0.0.0, Culture=neutral, P" + 
			"ublicKeyToken=b77a5c561934e089";
			lr.log("Event 76: Activator.CreateInstance(assemblyName_2, \"MS.Internal.SystemDataExtensi" +
			  "on\");");
			ObjectHandle_2 = Activator.CreateInstance(assemblyName_2, "MS.Internal.SystemDataExtension");

			lr.log("Event 77: ObjectHandle_2.Unwrap();");
			Object_2 = ObjectHandle_2.Unwrap();

			lr.log("Event 78: new DataSet();");
			DataSet_1 = new DataSet();

			value_1 = ((CultureInfo)(LrReplayUtils.GetSerializedObject("Serialization_1001.bin")));
			lr.log("Event 79: DataSet_1.Locale = value_1;");
			DataSet_1.Locale = value_1;

			lr.log("Event 80: new DataTable(\"Table1\");");
			DataTable_1 = new DataTable("Table1");

			#warning:  Code Generation Warning
			// Note:  value_1 is not included in the recording filter.
			// Its state may have changed since it was last detected.
			lr.log("Event 81: DataTable_1.Locale = value_1;");
			DataTable_1.Locale = value_1;

			lr.log("Event 82: DataTable_1.Columns;");
			DataColumnCollection_1 = DataTable_1.Columns;

			lr.log("Event 83: DataColumnCollection_1.Add(\"ID\", typeof(int));");
			DataColumn_1 = DataColumnCollection_1.Add("ID", typeof(int));

			lr.log("Event 84: DataSet_1.Tables;");
			DataTableCollection_1 = DataSet_1.Tables;

			lr.log("Event 85: DataTableCollection_1.Add(DataTable_1);");
			// Table DataTable_1 is empty
			DataTableCollection_1.Add(DataTable_1);
			// Table DataTable_1 is empty

			lr.log("Event 86: new DataTable(\"Table2\");");
			DataTable_2 = new DataTable("Table2");

			#warning:  Code Generation Warning
			// Note:  value_1 is not included in the recording filter.
			// Its state may have changed since it was last detected.
			lr.log("Event 87: DataTable_2.Locale = value_1;");
			DataTable_2.Locale = value_1;

			lr.log("Event 88: DataTable_2.Columns;");
			DataColumnCollection_2 = DataTable_2.Columns;

			lr.log("Event 89: DataColumnCollection_2.Add(\"ID\", typeof(int));");
			DataColumn_2 = DataColumnCollection_2.Add("ID", typeof(int));

			lr.log("Event 90: DataTableCollection_1.Add(DataTable_2);");
			// Table DataTable_2 is empty
			DataTableCollection_1.Add(DataTable_2);
			// Table DataTable_2 is empty

			lr.log("Event 91: new DataRelation(\"IDRelation\", DataColumn_1, DataColumn_2);");
			DataRelation_1 = new DataRelation("IDRelation", DataColumn_1, DataColumn_2);

			lr.log("Event 92: DataSet_1.Relations;");
			DataRelationCollection_1 = DataSet_1.Relations;

			lr.log("Event 93: DataRelationCollection_1.Add(DataRelation_1);");
			DataRelationCollection_1.Add(DataRelation_1);

			lr.end_transaction("login", lr.AUTO);

			lr.think_time(13);

			lr.start_transaction("send_message");

			String connectionString_2;
			connectionString_2 = "server=localhost;port=3306;User Id=root;password=123456;Database=time" + 
			"line;charset=utf8";
			lr.log("Event 110: new MySqlConnection(connectionString_2);");
			MySqlConnection_3 = new MySqlConnection(connectionString_2);

			lr.think_time(11);

			lr.log("Event 111: MySqlConnection_3.Open();");
			MySqlConnection_3.Open();

			String cmdText_3;
			cmdText_3 = "insert into news (`content`, `imageURL`, `author`, `posttime`) values" + 
			"('test message','C:\\\\Users\\\\xsk\\\\Pictures\\\\pic.jpg','test','2" + 
			"018Äê12ÔÂ30ÈÕ 15:20')";
			lr.log("Event 112: new MySqlCommand(cmdText_3, MySqlConnection_3);");
			MySqlCommand_3 = new MySqlCommand(cmdText_3, MySqlConnection_3);

			lr.log("Event 113: MySqlCommand_3.ExecuteNonQuery();");
			Int32RetVal = MySqlCommand_3.ExecuteNonQuery();

			lr.log("Event 114: MySqlConnection_3.Close();");
			MySqlConnection_3.Close();

			lr.end_transaction("send_message", lr.AUTO);

			lr.think_time(13);

			lr.start_transaction("refresh_message");

			lr.log("Event 117: MySqlConnection_2.Open();");
			MySqlConnection_2.Open();

			String cmdText_4;
			cmdText_4 = "select * from news,users where news.author=users.username";
			lr.log("Event 118: new MySqlCommand(cmdText_4, MySqlConnection_2);");
			MySqlCommand_4 = new MySqlCommand(cmdText_4, MySqlConnection_2);

			lr.log("Event 119: MySqlCommand_4.ExecuteReader();");
			MySqlDataReader_3 = MySqlCommand_4.ExecuteReader();

			lr.log("Event 416: LrReplayUtils.DoDataRead(MySqlDataReader_3, out valueTable_3, true, 11" +
			  ");");
			LrReplayUtils.DoDataRead(MySqlDataReader_3, out valueTable_3, true, 11);
			DATASET_XML(3);

			lr.log("Event 187: MySqlDataReader_3.Close();");
			MySqlDataReader_3.Close();

			lr.log("Event 188: MySqlConnection_2.Close();");
			MySqlConnection_2.Close();

			lr.end_transaction("refresh_message", lr.AUTO);

			lr.think_time(15);

			lr.start_transaction("more_message");

			lr.log("Event 192: MySqlConnection_2.Open();");
			MySqlConnection_2.Open();

			String cmdText_5;
			cmdText_5 = "select * from news,users where news.author=users.username";
			lr.log("Event 193: new MySqlCommand(cmdText_5, MySqlConnection_2);");
			MySqlCommand_5 = new MySqlCommand(cmdText_5, MySqlConnection_2);

			lr.log("Event 194: MySqlCommand_5.ExecuteReader();");
			MySqlDataReader_4 = MySqlCommand_5.ExecuteReader();

			lr.log("Event 417: LrReplayUtils.DoDataRead(MySqlDataReader_4, out valueTable_4, true, 11" +
			  ");");
			LrReplayUtils.DoDataRead(MySqlDataReader_4, out valueTable_4, true, 11);
			DATASET_XML(4);

			lr.log("Event 262: MySqlDataReader_4.Close();");
			MySqlDataReader_4.Close();

			lr.log("Event 263: MySqlConnection_2.Close();");
			MySqlConnection_2.Close();

			lr.log("Event 264: MySqlConnection_2.Open();");
			MySqlConnection_2.Open();

			String cmdText_6;
			cmdText_6 = "select * from news,users where news.author=users.username";
			lr.log("Event 265: new MySqlCommand(cmdText_6, MySqlConnection_2);");
			MySqlCommand_6 = new MySqlCommand(cmdText_6, MySqlConnection_2);

			lr.log("Event 266: MySqlCommand_6.ExecuteReader();");
			MySqlDataReader_5 = MySqlCommand_6.ExecuteReader();

			lr.log("Event 418: LrReplayUtils.DoDataRead(MySqlDataReader_5, out valueTable_5, true, 11" +
			  ");");
			LrReplayUtils.DoDataRead(MySqlDataReader_5, out valueTable_5, true, 11);
			DATASET_XML(5);

			lr.log("Event 334: MySqlDataReader_5.Close();");
			MySqlDataReader_5.Close();

			lr.log("Event 335: MySqlConnection_2.Close();");
			MySqlConnection_2.Close();

			lr.log("Event 339: MySqlConnection_2.Open();");
			MySqlConnection_2.Open();

			String cmdText_7;
			cmdText_7 = "select * from news,users where news.author=users.username";
			lr.log("Event 340: new MySqlCommand(cmdText_7, MySqlConnection_2);");
			MySqlCommand_7 = new MySqlCommand(cmdText_7, MySqlConnection_2);

			lr.log("Event 341: MySqlCommand_7.ExecuteReader();");
			MySqlDataReader_6 = MySqlCommand_7.ExecuteReader();

			lr.log("Event 419: LrReplayUtils.DoDataRead(MySqlDataReader_6, out valueTable_6, true, 11" +
			  ");");
			LrReplayUtils.DoDataRead(MySqlDataReader_6, out valueTable_6, true, 11);
			DATASET_XML(6);

			lr.log("Event 409: MySqlDataReader_6.Close();");
			MySqlDataReader_6.Close();

			lr.log("Event 410: MySqlConnection_2.Close();");
			MySqlConnection_2.Close();

			lr.end_transaction("more_message", lr.AUTO);

            return 0;
        }
    }
}
