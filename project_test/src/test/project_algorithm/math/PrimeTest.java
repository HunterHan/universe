package math;

import java.util.List;

import org.junit.Test;

import com.laiwu.algorithm.math.Prime;

public class PrimeTest {

	@Test
	public void primeTest() {
		int range = 100;
		List<Integer> primes = Prime.getPrime(range);
		System.out.println("小于" + range + "的素数: \t" + primes.toString());
	}
}
