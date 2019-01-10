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
        
        private ObjectHandle ObjectHandle_1;
        
        private Object Object_1;
        
        private MySqlConnection MySqlConnection_1;
        
        private MySqlCommand MySqlCommand_1;
        
        private MySqlDataReader MySqlDataReader_1;
        
        private DataTable valueTable_1;
        
        private MySqlConnection MySqlConnection_2;
        
        private MySqlCommand MySqlCommand_2;
        
        private MySqlDataReader MySqlDataReader_2;
        
        private DataTable valueTable_2;
        
        private ObjectHandle ObjectHandle_2;
        
        private Object Object_2;
        
        private DataSet DataSet_1;
        
        private CultureInfo value_1;
        
        private DataTable DataTable_1;
        
        private DataColumnCollection DataColumnCollection_1;
        
        private DataColumn DataColumn_1;
        
        private DataTableCollection DataTableCollection_1;
        
        private DataTable DataTable_2;
        
        private DataColumnCollection DataColumnCollection_2;
        
        private DataColumn DataColumn_2;
        
        private DataRelation DataRelation_1;
        
        private DataRelationCollection DataRelationCollection_1;
        
        private MySqlConnection MySqlConnection_3;
        
        private MySqlCommand MySqlCommand_3;
        
        private Int32 Int32RetVal;
        
        private MySqlCommand MySqlCommand_4;
        
        private MySqlDataReader MySqlDataReader_3;
        
        private DataTable valueTable_3;
        
        private MySqlCommand MySqlCommand_5;
        
        private MySqlDataReader MySqlDataReader_4;
        
        private DataTable valueTable_4;
        
        private MySqlCommand MySqlCommand_6;
        
        private MySqlDataReader MySqlDataReader_5;
        
        private DataTable valueTable_5;
        
        private MySqlCommand MySqlCommand_7;
        
        private MySqlDataReader MySqlDataReader_6;
        
        private DataTable valueTable_6;
        
        private static Random rm = new Random();
        private string username = "tester"+rm.Next(0,999999);
    }
}
