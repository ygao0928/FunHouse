package wechat.utils;

/**
 * <description>
 *
 * </description>
 *
 * @author YYang
 * @version 1.0
 * @date 2020/12/3 17:13
 */
public class RandomCode {
    public String generateRandomStr(int len) {

        String code = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDGFHJKLZXCVBNM";//定义字符源

        String str = "";

        for (int i=1; i<=len; i++) {

            //循环随机获得当次字符，并移走选出的字符

            String num = String.valueOf(code.charAt((int)(Math.random() * code.length())));
            str += num;
          //code = code.replaceAll(num,"");//将已选字符格式化
        }
        return str;
    }

}
