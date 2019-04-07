package linkedlist;
import java.io.*;
import java.util.Scanner;
public class slinkedlist {
ayman head;

 static class ayman{
	ayman value;
	 int data;
	 ayman(int d){data=d;}
 }
 public static slinkedlist insert(slinkedlist list,int data) {
ayman new_node=new ayman(data);
new_node.value=null;
if(list.head==null) {list.head=new_node;}
else {
	 ayman last=list.head;
	 while(last.value!=null) {last=last.value;}
	 last.value=new_node;
}
	 return list;
	 
 }
 public static void printlist(slinkedlist list) {
	 ayman node=list.head;
	 while(node.value!=null) {
		 System.out.print(node.data+" ");
		 node=node.value;
	 }
 }
 public static void main(String[] agrs) {
 Scanner object=new Scanner(System.in);
 slinkedlist list=new slinkedlist();
 int a=object.nextInt();
 while(a!=-1) {
	 list=insert(list,a);
	 a=object.nextInt();
 }
 

 printlist(list);
  
}
}