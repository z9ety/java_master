package char7.casting;

public class MainExe {

	public static void main(String[] args) {
		
		double d1 = 100;
		int n1 = (int) 100.0;
		// promotion(�ڵ�����ȯ)
		Parent p1 = new Child();

		// casting(��������ȯ)
		// Child c1 = (Child) new Parent();

		// ��������ȯ
		// �ڽ��ν��Ͻ��� ��������ȯ OK.
		// �θ��ν��Ͻ��� ��������ȯ NG.
		// ����: �����Ͽ���/ ���࿡��
		Parent p2 = new Parent();
		Child c2 = new Child();

		p2 = c2;
		// ����ȯ���� �ν��Ͻ� ���� üũ.
		if (p2 instanceof Child) {
			Child c3 = (Child) p2;
			System.out.println("����Ϸ�");
		}
		System.out.println("end of prog.");
	}
}
