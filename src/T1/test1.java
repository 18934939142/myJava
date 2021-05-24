package T1;

import java.util.Stack;

/**
 * @author mojiangze
 *  数组去重
 */
public class test1 {

    static int removeDuplicates(int[] arr){
        int len= arr.length;
        if (len==0) {
            return 0;
        }
        int i=0,j=1;//快慢指针
        while (j<len){
            if (arr[i]!=arr[j]){
                arr[++i]=arr[j];
            }
            j++;
        }
        return i+1;
    }
    static String removeString(String s){
        Stack<Character> stk=new Stack<>();
        int[] count=new int[256];
        for (int i = 0; i <s.length() ; i++) {
            count[s.charAt(i)]++;           //依次取出每个字符到ascll码  a:97->count[97]++;
        }
        boolean[] inStack=new boolean[256];//默认全部为false

        for (char ch:s.toCharArray()
             ) {
          //  boolean flag=false;
            //遍历每个字符,并将其出现次数减1
            count[ch]--;
            //判断字符是否出现 出现则直接跳过
            if (inStack[ch]) {
                continue;
            }
            //stk.isEmpty()-->判断栈内是否为空 stk.peek()查看栈顶对象
            while (!stk.isEmpty() && stk.peek()>ch){
                //如果栈顶元素次数为0 则不能踢出栈
                if (count[stk.peek()]==0){
//                    char temp=stk.pop();
//                    stk.push(ch);
//                    stk.push(temp);
//                    inStack[ch]=true;
//                    inStack[temp]=true;
//                    flag=true;
                    break;
                }else {
                    //如果次数大于0 则提出栈 并设为未出现
                    inStack[stk.pop()]=false;
                }
            }
            //压入栈顶
           // if (flag==false) {
                stk.push(ch);
                inStack[ch]=true;
            //}
        }
        StringBuilder sb=new StringBuilder();
        while (!stk.empty()){
            sb.append(stk.pop());
        }

        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        int[] arr ={1,2,2,3,3,3,4,4};
        int n=removeDuplicates(arr);
        for (int i = 0; i <n ; i++) {
            System.out.print(arr[i]+" ");
        }
        //
        String str="cbacdcbc";
        String str2=removeString(str);

        System.out.println(str2);

    }
}
