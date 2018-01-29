package Ningbo.String;

/**
 * Created by zhang on 6/16/16.
 *
 * key point 1 : i < sourceLen - targetLen + 1,最后一个要比较的index推导一下就可以,要小心
 * 自己写就写出了key point 1 : i < sourceLen - targetLen, 导致了["", ""]的case过不了
 *
 */
public class StrStr {
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        int sourceLen = source.length();
        int targetLen = target.length();

        //useless code
//        if (sourceLen < targetLen) {
//            return -1;
//        }

//        for (int i = 0; i < sourceLen - targetLen; i++) {
        //key point 1 : i < sourceLen - targetLen + 1
        for (int i = 0; i < sourceLen - targetLen + 1; i++) {
            int j = 0;
            for (j = 0; j < targetLen; j++ ) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (targetLen == j) {
                return i;
            }
        }

        return -1;
    }
}
