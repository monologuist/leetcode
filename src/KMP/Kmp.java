package KMP;

public class Kmp {
    //获得最长公共前后缀表
    static void prefix_table(String pattern[], int prefix[], int n){
        //这个表的第一位一定是0
        prefix[0] = 0;
        //len：目前最长的公共前后缀长度，即prefix表里的数字
        int len = 0;
        //pattern[i]
        int i = 1;
        while (i < n){
            //情况1：如果我已经填了一部分prefix表，想接着填，且想让这个最长公共前后缀变长
            //那么我只需要做的就是判断能不能加上一个字符，增加这个公共部分，即判断我手头的这个和我想加的是否一致
            if (pattern[i] == pattern[len]){//一致
                len++;//可以增加目前最长的公共前后缀长度啦
                prefix[i] = len;//拿这个值来填表
                i++;//游标向后移一位
            }
            else {//如果不相等呢？
                if (len > 0){//跳着去比 这里比较难想
                    len = prefix[len-1];
                }
                else {//测试发现一直卡在i=1 len=0 需要做处理来跳出
                    prefix[i] = len;//写prefix[i] = 0;也可以
                    i++;
                }
            }
        }
    }

    static void move_prefix_table(int prefix[], int n){//把前缀表向后移动一位，第一位改为-1，获得传说中的next表
        for (int i = n-1; i > 0; i--) {
            prefix[i] = prefix[i-1];
        }
        prefix[0] = -1;
    }

    static void kmp_search(String text[],String pattern[]){//准备工作已经完成
        //做一些规定
        //text[i] len(text) = m
        //pattern[j] len(pattern) = n
        int n = pattern.length;
        int m = text.length;
        int i = 0;
        int j = 0;
        int prefix[] = new int[n];
        prefix_table(pattern,prefix,n);
        move_prefix_table(prefix,n);

        while (i < m){
            //4。如果已经判断到最后一个 那么输出
            if (j == n-1 && text[i] == pattern[j]){
                System.out.println("Found pattern at "+(i-j));
                //不确定后面是否还有可以匹配到的字符，需要继续匹配
                j = prefix[j];
            }
            //1。逐位判断，相同则右边后移继续判断
            if (text[i] == pattern[j]){
                i++;j++;
            }
            else {//2。不相等了，需要用prefix表中的值来对准j，让pattern整体后移
                j = prefix[j];
                if (j == -1){//3。还有个小问题，如果遇到j=-1怎么办？把i和j整体右移一格
                    i++;j++;
                }
            }
        }

    }

    public static void main(String[] args) {
        String pattern[] = {"A","B","A","B","C","A","B","A","A"};
        String text[] = {"A","B","A","B","A","B","C","A","B","A","A","M","A","C","A","B","A","A","B","A","B","C","A","B","A","A"};
        kmp_search(text,pattern);
        /**
         * int prefix[] = new int[9];
         *         int n = 9;
         *         prefix_table(pattern,prefix,n);
         *         move_prefix_table(prefix,n);
         *         int i;
         *         for (i=0;i<n;i++){
         *             System.out.println(prefix[i]);
         *         }
         */


    }


}
