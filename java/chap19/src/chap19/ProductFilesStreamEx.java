package chap19;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

class Car{
	private int month;
	private int con;
	private String car;
	private int qty;
	private String remark;
	public Car(int month, int con, String car, int qty, String remark) {
		super();
		this.month = month;
		this.con = con;
		this.car = car;
		this.qty = qty;
		this.remark = remark;
	}
	//getter
	public int getMonth() {
		return month;
	}
	public int getCon() {
		return con;
	}
	public String getCar() {
		return car;
	}
	public int getQty() {
		return qty;
	}
	public String getRemark() {
		return remark;
	}
	@Override
	public String toString() {
		return "Car month=" + month + ", con=" + con + ", car=" + car + ", qty=" + qty + ", remark=" + remark ;
	}
	
}
public class ProductFilesStreamEx {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("product.txt"));
		//���� �Ǹ� ������ Map��ü�� �����ϱ�.
		Map<Integer,Long> map = br.lines()
				.map(s->{ //���ڿ�  s: 1,2,�ƹ���,3,(��ǰ����) �̷� ����
					String[] str = s.split(",");//","�� ����
					String temp = "";
				try {
					temp = str[4]; //��ǰ����
			}catch(ArrayIndexOutOfBoundsException e) {
				temp= "";
			}
			return new Car(Integer.parseInt(str[0]), //��
					Integer.parseInt(str[1]),str[2], //����,�ڵ����̸�
					Integer.parseInt(str[3]),temp);  //����,temp=��ǰ���� / ������� ��Ʈ�� ����
		}).filter(s->s.getCon() ==2) //�Ǹ�.
				.collect(Collectors.groupingBy(Car::getMonth, //=> ������ ī��Ʈ? Key �� = �� 
						Collectors.summingLong(Car::getQty)));//Collectors.summingLong(Car::getQty) : ������ ��
		System.out.println(map);
		
		//�ڵ����� ��ǰ ������ Map��ü�� �����ϱ�
		br = new BufferedReader(new FileReader("product.txt")); //�ٽ� �о���
		Map<String, Long> map2 = br.lines()
				.map(s->{
					String [] str = s.split(",");
					String temp = "";
				try {
					temp = str[4]; //��ǰ ����
				}catch(ArrayIndexOutOfBoundsException e) {
					temp= "";
				}
			return new Car(Integer.parseInt(str[0]), 
					Integer.parseInt(str[1]),str[2], 
					Integer.parseInt(str[3]),temp);
		}).filter(s->s.getCon() == 3 ) //��ǰ
				.collect(Collectors.groupingBy(Car::getCar, //=>Key ,�ڵ����̸�
				Collectors.summingLong(Car::getQty)));
		System.out.println(map2);
	}
}