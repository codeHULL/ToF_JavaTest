package com.ToF.test;

/**
 * @Author:
 * @Description:
 * @params:
 * @Data: Created in  16:08 2018/8/6
 * @Modified By:
 */
public class Test_10_numberOfOne {
/**
 * 请实现一个函数， 输入一个整数，输出该数二进制表示中1的个数。
 * 例如把9表示成二进制是1001 ，有2位是1. 因此如果输入9，该出2。
 *
 * @param n 待的数字
 * @return 数字中二进制表表的1的数目
 */
    public static int numberOfOne(int n){
        //记录数字1中的位数
        int result = 0;
        //java中int整形占四个字节，总计32位
        //对每一个位置与1进行求与操作，在累加就可以求出当前数字的表示是多少位1
        for (int i = 0;i<32;i++){
            result +=(n&1);
            n>>>=1;
        }
        return result;
    }

    //效率更高的解法(比较好的解法）
    /*
    * 如果一个整数不为0，那么这个整数至少有一位是1。
    * 如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。
    * 其余所有位将不会受到影响。
      举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。如1100&1011=1000.
      也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
    * */
    public static int numberOfOne2(int n){
        int result = 0;
        //数字的二进制中有多少个1就进行多少位操作
        while (n!=0){
            result++;
            //从最右边的1开始，每一次操作都使n的最右边的1变成了0
            n = (n-1)&n;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfOne(9));
    }


}