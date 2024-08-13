package cn.hutool.core.codec;

import org.junit.Assert;
import org.junit.Test;

/**
 * 当前的这个实现已经被废弃
 */
public class BCDTest {

	@Test
	public void bcdTest(){
		final String strForTest = "123456ABCDEF";

		// 什么是BCD？BCD码这种编码形式利用了四个位元来储存一个十进制的数码，使二进制和十进制之间的转换得以快捷的进行
		//转BCD
		final byte[] bcd = BCD.strToBcd(strForTest);
		final String str = BCD.bcdToStr(bcd);
		//解码BCD
		Assert.assertEquals(strForTest, str);
	}
}
