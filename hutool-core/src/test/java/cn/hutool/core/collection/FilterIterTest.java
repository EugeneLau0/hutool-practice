package cn.hutool.core.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

/**
 * {@link FilterIter} 单元测试
 * @author chao.wang
 */
public class FilterIterTest {

	@Test
	public void checkFilterIter() {
		Iterator<String> it = ListUtil.of("1", "2").iterator();
		// filter 为null
		FilterIter<String> filterIter = new FilterIter<>(it, null);

		int count = 0;
		while (filterIter.hasNext()) {
			if(filterIter.next() != null){
				count++;
			}
		}
		Assert.assertEquals(2, count);

		// 返回的list是不可变的
		it = ListUtil.of("1", "2").iterator();
		// filter 不为空
		filterIter = new FilterIter<>(it, (key) -> key.equals("1"));
		count = 0;
		while (filterIter.hasNext()) {
			if(filterIter.next() != null){
				count++;
			}
		}
		Assert.assertEquals(1, count);
	}

}
