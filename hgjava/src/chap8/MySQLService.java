package chap8;

// ��� : extends �θ�Ŭ����.
// ���� : implements �������̽�.
public class MySQLService implements DatabaseService {

	@Override
	public void add() {
		System.out.println("MySQL �Է�ó��.");
	}

	@Override
	public void modify() {
		System.out.println("MySQL ����ó��.");
	}

	@Override
	public void remove() {
		System.out.println("MySQL ����ó��.");
	}

}
