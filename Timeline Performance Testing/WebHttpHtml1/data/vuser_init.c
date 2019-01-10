/* -------------------------------------------------------------------------------
	Script Title       : 
	Script Description : 
                        
                        
	Recorder Version   : 911
   ------------------------------------------------------------------------------- */

vuser_init()
{

	web_url("localhost:8100", 
		"URL=http://localhost:8100/", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=", 
		"Snapshot=t1.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=/assets/fonts/roboto-light.woff", ENDITEM, 
		"Url=/assets/fonts/roboto-medium.woff", ENDITEM, 
		"Url=/assets/imgs/15.jpg", ENDITEM, 
		"Url=/assets/imgs/5.jpg", ENDITEM, 
		"Url=/assets/imgs/7.jpg", ENDITEM, 
		"Url=/assets/imgs/4.jpg", ENDITEM, 
		"Url=/assets/imgs/6.jpg", ENDITEM, 
		"Url=/assets/imgs/8.jpg", ENDITEM, 
		"Url=/assets/imgs/9.jpg", ENDITEM, 
		"Url=/assets/fonts/ionicons.woff?v=3.0.0-alpha.3", ENDITEM, 
		"Url=/assets/imgs/10.jpg", ENDITEM, 
		LAST);

	web_websocket_connect("ID=0", 
		"URI=ws://localhost:53703/", 
		"Origin=http://localhost:8100", 
		"OnOpenCB=OnOpenCB0", 
		"OnMessageCB=OnMessageCB0", 
		"OnErrorCB=OnErrorCB0", 
		"OnCloseCB=OnCloseCB0", 
		LAST);

	web_websocket_connect("ID=1", 
		"URI=ws://localhost:35729/livereload", 
		"Origin=http://localhost:8100", 
		"OnOpenCB=OnOpenCB1", 
		"OnMessageCB=OnMessageCB1", 
		"OnErrorCB=OnErrorCB1", 
		"OnCloseCB=OnCloseCB1", 
		LAST);

	web_websocket_send("ID=1", 
		"Buffer={\"command\":\"hello\",\"protocols\":[\"http://livereload.com/protocols/official-6\",\"http://livereload.com/protocols/official-7\"],\"ver\":\"2.2.2\",\"snipver\":1}", 
		"IsBinary=0", 
		LAST);

	/*Connection ID 1 received buffer WebSocketReceive0*/

	web_websocket_send("ID=1", 
		"Buffer={\"command\":\"info\",\"plugins\":{\"less\":{\"disable\":false,\"version\":\"1.0\"}},\"url\":\"http://localhost:8100/\"}", 
		"IsBinary=0", 
		LAST);

	lr_start_transaction("login");

	web_revert_auto_header("Sec-WebSocket-Version");

	lr_think_time(16);

	web_custom_request("login", 
		"URL=http://localhost:8080/users/login", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=http://localhost:8100/", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"Body=message={\"username\":\"tester1\",\"password\":\"tester1\"}", 
		LAST);

	web_custom_request("newsList", 
		"URL=http://localhost:8080/news/newsList", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=http://localhost:8100/", 
		"Snapshot=t5.inf", 
		"Mode=HTML", 
		"Body=message={}", 
		LAST);

	web_set_sockets_option("SSL_VERSION", "2&3");

	lr_end_transaction("login",LR_AUTO);

	return 0;
}
