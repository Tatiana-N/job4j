package ru.job4j.gc.references;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
//Сильная ссылка является "обычной" ссылкой
public class StrongDemo {
	
	public static void main(String[] args) throws InterruptedException {
		example1();
		//example2();
		//example3();
	}
	
	private static void example1() throws InterruptedException {
		// создаем объекты и далее их за'null'яем.
		// Вызываем сборщик мусора и ждем некоторое время. Объекты удаляются, т.к. ссылки на них null
		Object[] objects = new Object[100];
		for (int i = 0; i < 100; i++) {
			objects[i] = new Object() {
				@Override
				protected void finalize() throws Throwable {
					System.out.println("Object removed!");
				}
			};
		}
		for (int i = 0; i < 100; i++) {
			objects[i] = null;
		}
		System.gc();
		TimeUnit.SECONDS.sleep(5);
	}
	
	private static void example2() throws InterruptedException {
		// создаем объекты вместе с вложенными. Удаляя внешние объекты как в примере выше удаляются и вложенные, не смотря на то что они не null.
		Object[] objects = new Object[100];
		for (int i = 0; i < 100; i++) {
			Object object = new Object() {
				Object innerObject = new Object() {
					@Override
					protected void finalize() throws Throwable {
						System.out.println("Remove inner object!");
					}
				};
			};
			objects[i] = object;
		}
		for (int i = 0; i < 100; i++) {
			objects[i] = null;
		}
		System.gc();
		TimeUnit.SECONDS.sleep(5);
	}
	
	private static void example3() {
		//Проблема данного типа ссылок является то, что если в программе есть неиспользуемые ссылки на созданные объекты, то они не будут удалены,
		
		List<String> strings = new ArrayList<>();
		while (true) {
			//что приведет к утечке памяти, что в свою очередь может привести к ошибке OutOfMemoryException - ситуации когда программе не хватает выделенной памяти.
			strings.add(String.valueOf(System.currentTimeMillis()));
		}
	}
}

