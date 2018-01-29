package Ningbo.DataStructure;

/**
 * Created by zhang on 7/13/16.
 *
 * char(abc) = (33^2 * a + 33 * b + c) % hash_size
 *           = (33(33 * a + b) + c) % hash_size
 *           = ((33(33(33 * 0 + a)) + b) + c) % hash_size
 *
 *
 *           最小答案为 (33 * 0 + a) % hash_size
 *           后面的答案递归
 *
 *           有效避免了hash值溢出的问题
 *
 *           取模的一个重要公式 ----> (M * N) % P = (M % P) * (N % P)
 */
public class HashFunction {
    public int hashCode(char[] key,int HASH_SIZE) {
        if (key == null || key.length == 0) {
            return -1;
        }

        long hash = 0;
        int magic_number = 33;
        for (int i = 0; i < key.length; i++) {
            hash = hash * magic_number + (int)key[i];
            hash %= HASH_SIZE;
        }
        return (int)hash;
    }
}
