package chap05;

//�������� ������ ������ ����
class Friend{		//Ŭ���� => ������ Ÿ��
	String name;	//�ʵ�
	int age;		//�ʵ�
	double height; 	//�ʵ�
}

public class ReferenceExe1 {
	
	public static void main(String[] args) {
		
		//�⺻ Ÿ�� : ������ ���� ����� ����
		int a = 10;
		int b = a;
		System.out.println("a = "+ a + ", b = " + b);
		
		a = 20;
		System.out.println("a = "+ a + ", b = " + b);	//a�� �ٲ㵵 b�� �״��
		
		//���� Ÿ�� : ������ �ּҰ��� ����Ǿ� ����
		//���� ���� ��� ��(X) => ���� ���� �ּҸ� ��� ����(O)
			
		String name = "�ſ��";	//�ּҰ��� "�ſ��" ����ִ� �ּ�
		
		String name1 = "�ſ��";				//name, name1 ���� �޸� �ּ� ����Ŵ
		System.out.println(name == name1);		//true
		System.out.println(name.equals(name1));	//true
		
		String name2 = new String("�ſ��");	//���ο� �޸� �ּ� ����
		System.out.println(name == name2);		//false
		System.out.println(name.equals(name2));	//true
		
		Friend myFriend = new Friend();		//new => �� �޸𸮻� ��ü ����
		myFriend.name = "��ö��";
		myFriend.age = 20;
		myFriend.height = 178.3;
		
//		Friend ourFriend = myFriend;		//���� �ƴ� �ּҸ� ���� 
//		
//		myFriend.name = "ȫ�浿";
//		
//		System.out.println(ourFriend.name);
//		System.out.println(ourFriend.age);
//		System.out.println(ourFriend.height);
		
		Friend yourFriend = new Friend();
		yourFriend.name = "��ö��";
		yourFriend.age = 20;
		yourFriend.height = 178.3;
		
		System.out.println(myFriend == yourFriend);	// �ּҰ� �� => false
		
		yourFriend = null;
		System.out.println(myFriend.name);
		try {
			System.out.println(yourFriend.name);	//null�� ������ ���� �߻�
		} catch(Exception e) {						//���� ó��
			System.out.println("null���� �����մϴ�.");
		}
		
		

		
		
	}

}
