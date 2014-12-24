package leetcode;

public class SingleNumberII {
	public static void main(String[] args) {
		SingleNumberII sn = new SingleNumberII();
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 9, 8, 6, 5, 4, 2, 1, 3,
				1, 2, 3, 4, 5, 6, 8, 9, 10 };
		int ret = sn.singleNumber3(A);
		System.out.println(ret);
		int data[] = { 1, 2, 2, 3, 3, 3, 3, 2, 2, 4, 1, 1, 1 };
		int ret1 = sn.singleNumberk(data, 4);
		System.out.println(ret1);
		System.out.println("-------------------retbelow-------------------");
		System.out.println("0&0-----(" + (0 & 0) + ")");
		System.out.println("1&0-----(" + (1 & 0) + ")");
		System.out.println("0&1-----(" + (0 & 1) + ")");
		System.out.println("1&1-----(" + (1 & 1) + ")");
		System.err.println("-------------------test------------------------");
		System.out.println("0|0-----(" + (0 | 0) + ")");
		System.out.println("1|0-----(" + (1 | 0) + ")");
		System.out.println("0|1-----(" + (0 | 1) + ")");
		System.out.println("1|1-----(" + (1 | 1) + ")");
		System.out.println("-------------------test-------------------");
		System.out.println("~1-----(" + (~1) + ")");
		System.out.println("~0-----(" + (~0) + ")");

		System.out.println("-------------------test-------------------");
		int[] bit = new int[32];
		int test = 8;
		for (int i = 0; i < 32; i++) {
			if (((test >> i) & 1) != 0) {
				bit[i]++;
			}
			System.out.print(bit[i]);
		}
		System.out.println();
	}

	public int singleNumberk(int[] A, int k) {
		int count[] = new int[32];
		int result = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				if (((A[j] >> i) & 1) != 0) {
					count[i]++;
				}
			}
			result |= ((count[i] % k) << i);
		}
		return result;
	}

	public int singleNumber3(int[] A) {
		int count[] = new int[32];
		int result = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				if (((A[j] >> i) & 1) != 0) {
					count[i]++;
				}
			}
			count[i] = count[i] % 3;
			result |= ((count[i] % 3) << i);
			// equals
			// result += ((count[i] % 3) << i)
		}
		return result;
	}

	public int singleNumber2(int[] A) {
		int ones = 0;
		int twos = 0;

		for (int i = 0; i < A.length; i++) {
			ones = (ones ^ A[i]) & ~twos;
			twos = (twos ^ A[i]) & ~ones;
		}
		return ones;
	}

	public int singleNumber(int[] A) {
		int ones = 0, twos = 0;
		int common_bit_mask;
		for (int i = 0; i < A.length; i++) {
			/*
			 * The expression "one & arr[i]" gives the bits that are there in
			 * both 'ones' and new element from arr[]. We add these bits to
			 * 'twos' using bitwise OR
			 * 
			 * Value of 'twos' will be set as 0, 3, 3 and 1 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */

			twos |= (ones & A[i]);
			/*
			 * XOR the new bits with previous 'ones' to get all bits appearing
			 * odd number of times
			 * 
			 * Value of 'ones' will be set as 3, 0, 2 and 3 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */
			ones ^= A[i];
			/*
			 * The common bits are those bits which appear third time So these
			 * bits should not be there in both 'ones' and 'twos'.
			 * common_bit_mask contains all these bits as 0, so that the bits
			 * can be removed from 'ones' and 'twos'
			 * 
			 * Value of 'common_bit_mask' will be set as 00, 00, 01 and 10 after
			 * 1st, 2nd, 3rd and 4th iterations respectively
			 */
			common_bit_mask = ~(ones & twos);
			/*
			 * Remove common bits (the bits that appear third time) from 'ones'
			 * 
			 * Value of 'ones' will be set as 3, 0, 0 and 2 after 1st, 2nd, 3rd
			 * and 4th iterations respectively
			 */
			ones &= common_bit_mask;
			/*
			 * Remove common bits (the bits that appear third time) from 'twos'
			 * 
			 * Value of 'twos' will be set as 0, 3, 1 and 0 after 1st, 2nd, 3rd
			 * and 4th itearations respectively
			 */
			twos &= common_bit_mask;
		}
		return ones;
	}
}
