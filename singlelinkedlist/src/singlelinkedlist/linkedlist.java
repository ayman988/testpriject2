package singlelinkedlist;
import java.io.*;
import java.util.Scanner;
public class linkedlist {
	Node head;
	Node tail;
	Node head2;
	Node tail2;
public static class Node{
	 int value;
	Node next;
	Node prev;
	Node(int data){value=data;}
	public  int getvalue() {return value;}
	public  Node getnext() {return next;}
}
  public static linkedlist insert (linkedlist list,int data) {
	  Node new_node=new Node(data);
	  new_node.next=null;
	  if(list.tail==null) {
		  list.tail=new_node;
		  list.tail.prev=null;}
	  else {
	  new_node.prev=list.tail;
	  list.tail.next=new_node;
	  list.tail=new_node;}
	  if(list.head==null) {list.head=new_node;}
	  
	  return list;
  }
 public static void printlist(linkedlist list) {
	
	 Node counter=list.head;
	 while(counter!=null) {System.out.print(counter.value+" ");
	 counter=counter.next; 
	 }
 }
public static double[] summary(linkedlist list){
	Node getsum=list.head;
	Node gettail=list.head;
	int max=list.head.value;
	int min=list.head.value;
	 double a[]=new double[5];
	 int c=0;
	 a[0]=0;
	while(getsum!=null) {a[0]=a[0]+getsum.getvalue();
	if(getsum.getvalue()>max) {max=getsum.getvalue();}
   if(getsum.getvalue()<min) {min=getsum.getvalue();}
	if(gettail!=null&&gettail.next!=null) {a[2]=getsum.next.getvalue();
	 gettail=gettail.next;
		gettail=gettail.next;}
	  getsum=getsum.getnext();
	c++;}
	a[1]=a[0]/c;
	a[3]=max;
	a[4]=min;
	return a;
	}
public static linkedlist reverse (linkedlist list) {
	Node temp=list.tail;
	Node temp2=list.head;
	temp2.prev=null;
	Node temp3=list.head.next;
	while(temp3!=null) {
	temp2.next=temp2.prev;
	temp2.prev=temp3;
	temp2=temp3;
	temp3=temp3.next;
	}
	list.tail.next=list.tail.prev;
	list.tail.prev=null;
	list.tail=list.head;
	list.head=temp;
	return list;
}
public static linkedlist remove(linkedlist list) {
	Node temp=list.head;
	Node temp2=list.head.next;
	while(temp2!=null&&temp2.next!=null) {
		temp2=temp2.next.next;
		temp=temp.next;
	}
	temp=temp.prev;
	temp.next=temp.next.next;
	temp.next.prev=temp;
	return list;
}
public static boolean palindrome(linkedlist list) {
	Node temp1=list.head;
	Node temp2=list.tail;
	boolean a=true;
	while(temp1!=temp2&&temp1.next!=temp2) {
		if(temp1.value!=temp2.value) {a=false;}
		temp1=temp1.next;
		temp2=temp2.prev;
	}
	return a;
}
public static linkedlist insertionsort(linkedlist list) {
Node temp1=list.head.next;
Node temp2=list.head;
int temp=list.head.next.value;
while(temp1!=null) {
	 temp=temp1.value;
	 while(temp2!=null&&temp2.value>temp) {
			 temp2.next.value=temp2.value;
			 temp2=temp2.prev;}
	 if(temp2!=null) {
		 temp2.next.value=temp;}
 else {
		list.head.value=temp; 
	 }
		 temp2=temp1;
		 if(temp1!=list.tail) {
			 temp=temp1.value;}
		 temp1=temp1.next;
		 }
	return list;
}
public static void printlist2(linkedlist list) {
	
	 Node counter=list.head2;
	 while(counter!=null) {System.out.print(counter.value+" ");
	 counter=counter.next; 
	 }
}
public static linkedlist evenlyindexed(linkedlist list) {
	linkedlist even=new linkedlist();
 Node temp1=list.head;
 while(temp1!=null&&temp1.next!=null) {
	 even=eveninsert(even,temp1.value);
	 temp1=temp1.next.next;
		}
 printlist2(even);
 return list;
	}
	public static linkedlist eveninsert(linkedlist list,int data) {
		Node even=new Node(data);
		even.next=null;
		if(list.head2==null) {list.head2=even;
		list.tail2=even;
		even.prev=null;}
		else {
	even.prev=list.tail2;
	list.tail2.next=even;
	list.tail2=even;
}
		return list;
	}
public static linkedlist merge(Node head,Node mid,Node tail,linkedlist list) {
	int c=0,s=0,i;
	Node temp1=head;
	Node temp2=mid.next;
	Node temp4=tail.next;
	while(temp1!=tail) {c++;
	temp1=temp1.next;}
	c++;
	temp1=head;
	int a[]=new int[c];
		while(temp1!=mid.next&&temp2!=temp4) {
		if(temp1.value<=temp2.value) {
			a[s]=temp1.value;
			s++;
			temp1=temp1.next;}
		else {
			a[s]=temp2.value;
			s++;
			temp2=temp2.next;}
		}
	while(temp1!=mid.next) {
		a[s]=temp1.value;
		s++;
		temp1=temp1.next;
	}
	while(temp2!=temp4) {
		a[s]=temp2.value;
		s++;
		temp2=temp2.next;
	}
		temp1=head;
		for(i=0;i<c;i++) {
			temp1.value=a[i];
			temp1=temp1.next;}
	return list;	
}
 public static void mergesort(Node left,Node right,linkedlist list) {
	if(left!=right) {
		Node middle=getmiddle(left,right);
	mergesort(left,middle,list);
	mergesort(middle.next,right,list);
	merge(left,middle,right,list);
	System.out.print("\n");
	printlist(list);
	}}
public static Node getmiddle(Node left,Node right) {
	Node mid=left;
	Node temp=left;
	while(temp!=right&&temp.next!=right) {
		temp=temp.next.next;
		mid=mid.next;
	}
	return mid;
}
public static void main(String[]agrs) {
	linkedlist list=new linkedlist();
	Scanner input=new Scanner(System.in);
	int a=input.nextInt();
	while(a!=-1) {list=insert(list,a);
	a=input.nextInt();}
	printlist(list);
	System.out.print("\n");
	double b[]=new double[5];
	int i;
	b=summary(list);
	//for(i=0;i<5;i++) {System.out.print(b[i]+" ");}
	System.out.print("\n");
	//remove(list);
	//insertionsort(list);
	//evenlyindexed(list);
	Node left=list.head;
	Node right=list.tail;
	mergesort(left,right,list);
}	
}


