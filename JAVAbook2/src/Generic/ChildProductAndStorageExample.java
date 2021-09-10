package Generic;

public class ChildProductAndStorageExample {
	public static void mainI(String[] args) {
		ChildProduct<Tv, String, String> product = new ChildProduct<>();
		product.setKind(new Tv());
		product.setModel("SmartTV");
		//���������� �θ�Ŭ������ Product�� ���� �޼ҵ带 ���
		product.setCompany("Samsung");
		//������ ��ӹ��� ChildProduct�� ���� �޼ҵ带 ���
		
		//Tv��ü�� ���� �� �ִ� Storage�� ������ 100���� ����
		Storage<Tv> storage = new StorageImpl<Tv>(100);
		//�� Storage�� �ε��� 0 �� Tv ��ü�� �����ؼ� ����
		storage.add(new Tv(), 0);
		//�׸��� �� add�ߴ� Tv ��ü�� get���� ������ ������ Tv Ÿ�� tv������ ����
		Tv tv = storage.get(0);
		
	}
}
