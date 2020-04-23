
UDP SERVER


import java.io.*;
import java.net.*;
class UDPServer
{
public static DatagramSocket serversocket;
public static DatagramPacket dp;
public static BufferedReader dis;
public static InetAddress ia;
public static byte buf[] = new byte[1024];
public static int cport = 789,sport=790;
public static void main(String[] a) throws IOException
{
serversocket = new DatagramSocket(sport);
dp = new DatagramPacket(buf,buf.length);
dis = new BufferedReader
(new InputStreamReader(System.in));
ia = InetAddress.getLocalHost();
System.out.println("Server is Running...");
while(true)
{
serversocket.receive(dp);
String str = new String(dp.getData(), 0,
dp.getLength());
if(str.equals("STOP"))
{
System.out.println("Terminated...");
break;
}
System.out.println("Client: " + str);
String str1 = new String(dis.readLine());
buf = str1.getBytes();
serversocket.send(new
DatagramPacket(buf,str1.length(), ia, cport));
}
}
}



UDP CLIENT


import java.io.*;
import java.net.*;
class UDPClient
{
public static DatagramSocket clientsocket;
public static DatagramPacket dp;
public static BufferedReader dis;
public static InetAddress ia;
public static byte buf[] = new byte[1024];
public static int cport = 789, sport = 790;
public static void main(String[] a) throws IOException
{
clientsocket = new DatagramSocket(cport);
dp = new DatagramPacket(buf, buf.length);
dis = new BufferedReader(new
InputStreamReader(System.in));
ia = InetAddress.getLocalHost();
System.out.println("Client is Running... Type 'STOP'to Quit");
while(true)
{
String str = new String(dis.readLine());
buf = str.getBytes();
if(str.equals("STOP"))
{
System.out.println("Terminated...");
clientsocket.send(new
DatagramPacket(buf,str.length(), ia,
sport));
break;
}
clientsocket.send(new DatagramPacket(buf,
str.length(), ia, sport));
clientsocket.receive(dp);
String str2 = new String(dp.getData(), 0,
dp.getLength());
System.out.println("Server: " + str2);
}
}
}