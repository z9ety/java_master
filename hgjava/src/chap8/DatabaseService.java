package chap8;

// �߻�Ŭ����ó�� �߻�޼ҵ常.
// Oracle : insert(), update() / MySQL : add(), modify()
// 
public interface DatabaseService {
	public static final String name = ""; // ����� ��밡��.
	// �Է�,����,����

	public abstract void add();

	public void modify();

	public void remove();
}
