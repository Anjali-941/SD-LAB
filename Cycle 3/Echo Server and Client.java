
ECHO SERVER


import java.io.*;
import java.net.*;

public class EchoServer
{
public static void main(String args[]) throws Exception
{
try
{
int Port;
BufferedReader Buf =new BufferedReader(new
InputStreamReader(System.in));
System.out.print(" Enter the Port Address : " );
Port=Integer.parseInt(Buf.readLine());
ServerSocket sok =new ServerSocket(Port);
System.out.println(" Server is Ready To Receive a Message. ");
System.out.println(" Waiting ..... ");
Socket so=sok.accept();
if(so.isConnected()==true)
            System.out.println(" Client Socket is Connected Succecfully. ");
InputStream in=so.getInputStream();
OutputStream ou=so.getOutputStream();
PrintWriter pr=new PrintWriter(ou);
BufferedReader buf=new BufferedReader(new
InputStreamReader(in));
String str=buf.readLine();
System.out.println(" Message Received From Client : " + str);
System.out.println(" This Message is Forwarded To Client. ");
pr.println(str);
pr.flush();
}
 catch(Exception e)
  {
  System.out.println(" Error : " + e.getMessage());
  }
}
}



ECHO CLIENT



import java.io.*;
import java.net.*;

public class EchoClient
{
public static void main(String args[]) throws Exception
{
try {
int Port;
BufferedReader Buf =new BufferedReader(new
InputStreamReader(System.in));
System.out.print(" Enter the Port Address : " );
Port=Integer.parseInt(Buf.readLine());
Socket sok=new Socket("localhost",Port);
if(sok.isConnected()==true)
            System.out.println(" Server Socket is Connected Succecfully. ");
InputStream in=sok.getInputStream();
OutputStream ou=sok.getOutputStream();
PrintWriter pr=new PrintWriter(ou);
BufferedReader buf1=new BufferedReader(new
InputStreamReader(System.in));
BufferedReader buf2=new BufferedReader(new
InputStreamReader(in));
String str1,str2;
System.out.print(" Enter the Message : ");
str1=buf1.readLine();
pr.println(str1);
pr.flush();
System.out.println(" Message Send Successfully. ");
str2=buf2.readLine();
System.out.println(" Message From Server : " + str2);
     }
  catch(Exception e)
  {
   System.out.println(" Error : " + e.getMessage());
  }
}
}
