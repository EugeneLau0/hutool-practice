package cn.hutool.core.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import cn.hutool.core.map.MapProxy;

/**
 * map代理的目的是：为了可以直接获取指定类型的value
 */
public class MapProxyTest {

	@Test
	public void mapProxyTest() {
		Map<String, String> map = new HashMap<>();
		map.put("a", "1");
		map.put("b", "2");

		MapProxy mapProxy = new MapProxy(map);
		Integer b = mapProxy.getInt("b");
		Assert.assertEquals(mapProxy.getStr("b"), "2");
		Assert.assertEquals(new Integer(2), b);

		Set<Object> keys = mapProxy.keySet();
		Assert.assertFalse(keys.isEmpty());

		Set<Entry<Object,Object>> entries = mapProxy.entrySet();
		Assert.assertFalse(entries.isEmpty());
	}

	private interface Student {
		Student setName(String name);
		Student setAge(int age);

		String getName();
		int getAge();
	}

	@Test
	public void classProxyTest() {
		Student student = MapProxy.create(new HashMap<>()).toProxyBean(Student.class);
		student.setName("小明").setAge(18);
		Assert.assertEquals(student.getAge(), 18);
		Assert.assertEquals(student.getName(), "小明");
	}
}
