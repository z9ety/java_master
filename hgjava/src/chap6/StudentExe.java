package chap6;

//�������: �迭.
// �߰�/����/����/���/�ܰ���ȸ.
public class StudentExe {
	// �迭:
	private Student[] students;

	// ������.
	StudentExe() {
		students = new Student[100];
		students[0] = new Student("23-001", "ȫ�浿", 77, 88);
		students[1] = new Student("23-002", "��ö��", 82, 85);
	}

	// �߰�.
	boolean addStudent(Student std) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = std;
//				break;
				return true; // �޼ҵ忡�� return���� �޼ҵ��� ��.
			}
		}
		return false;
	}

	// ���.
	Student[] getStudentList() {
		return students;
	}

	// �ܰ���ȸ.
	Student getStudent(String no) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStudentNo().equals(no)) {
				return students[i];
			}
		}
		return null;
	}

	// ����.
	boolean modifyStudent(String no, int eng, int mat) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStudentNo().equals(no)) {
				students[i].setStudentEng(eng);
				students[i].setStudentMath(mat);
				return true;
			}
		}
		return false;
	}

	// ����.///

	boolean removeStudent(String name) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStudentName().equals(name)) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}
}// end class
