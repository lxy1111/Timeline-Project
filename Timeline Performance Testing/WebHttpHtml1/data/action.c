Action()
{

	lr_rendezvous("send_message");

	web_add_cookie("SRCHUID=V=2&GUID=FBCAEB3687624A3D8261347ABA6EC2FB&dmnchg=1; DOMAIN=iecvlist.microsoft.com");

	web_add_cookie("SRCHD=AF=NOFORM; DOMAIN=iecvlist.microsoft.com");

	web_add_cookie("MC1=GUID=657172a976484949a3a6043a81954330&HASH=6571&LV=201804&V=4&LU=1523421138420; DOMAIN=iecvlist.microsoft.com");

	web_add_cookie("MUID=3FAE76A32C496E7322E07D6D284968D9; DOMAIN=iecvlist.microsoft.com");

	web_add_cookie("SRCHUSR=DOB=20180227; DOMAIN=iecvlist.microsoft.com");

	web_add_cookie("A=I&I=AxUFAAAAAAASBwAADr5JR1xLZS3QDN6geacRjQ!!&V=4; DOMAIN=iecvlist.microsoft.com");

	web_add_header("UA-CPU", 
		"AMD64");

	lr_think_time(13);

	web_url("iecompatviewlist.xml", 
		"URL=https://iecvlist.microsoft.com/IE11/1478281996/iecompatviewlist.xml", 
		"Resource=0", 
		"RecContentType=text/xml", 
		"Referer=", 
		"Snapshot=t6.inf", 
		"Mode=HTML", 
		LAST);

	lr_start_transaction("send_message");

	web_add_auto_header("Origin", 
		"http://localhost:8100");

	lr_think_time(15);

	web_custom_request("addNews", 
		"URL=http://localhost:8080/news/addNews", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=http://localhost:8100/", 
		"Snapshot=t7.inf", 
		"Mode=HTML", 
		"Body=message={\"content\":\"test message by tester1\",\"imageURL\":\"\",\"author\":\"tester1\"}", 
		LAST);

	web_custom_request("newsList_2", 
		"URL=http://localhost:8080/news/newsList", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=http://localhost:8100/", 
		"Snapshot=t8.inf", 
		"Mode=HTML", 
		"Body=message={}", 
		LAST);

	lr_end_transaction("send_message",LR_AUTO);

	lr_think_time(16);

	lr_start_transaction("refresh_message");

	web_custom_request("newsList_3", 
		"URL=http://localhost:8080/news/newsList", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=http://localhost:8100/", 
		"Snapshot=t9.inf", 
		"Mode=HTML", 
		"Body=message={}", 
		LAST);

	lr_end_transaction("refresh_message",LR_AUTO);

	lr_think_time(14);

	lr_start_transaction("more_message");

	web_custom_request("moreNews", 
		"URL=http://localhost:8080/news/moreNews", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=http://localhost:8100/", 
		"Snapshot=t10.inf", 
		"Mode=HTML", 
		"Body=message={}", 
		LAST);

	lr_end_transaction("more_message",LR_AUTO);

	return 0;
}