package chap8;

public class OracleService implements DatabaseService {

	@Override
	public void add() {
		System.out.println("Oracle �Է�ó��.");
	}

	@Override
	public void modify() {
		System.out.println("Oracle ����ó��.");
	}

	@Override
	public void remove() {
		System.out.println("Oracle ����ó��.");
	}

}
