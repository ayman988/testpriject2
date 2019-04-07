package linkedlis
public class node {
private int value;
 node next;
	public node(int v,node n){
		value=v;
		next=n;}
	public int getvalue() {return value;}
	public node getnext() {return next;}
	public void setvalue(int newvalue) {value=newvalue;}
	public void setnext(node newnext) {next=newnext;}	
	
}
