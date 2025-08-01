package StringAlgorithms;

import java.util.ArrayList;

public class RabinKarp {
  final int PRIME = 101;
  final long MOD = (long) (1e9 + 7);

  // precalculate pow
  public long[] calcPow(int n) {
    long[] arr = new long[n];

    arr[0] = 1;

    for (int i = 1; i < n; i++) {
      arr[i] = (arr[i - 1] * PRIME) % MOD;
    }

    return arr;
  }

  public long calculateHash(String s, long pow[]) {
    long hash = 0;
    for (int i = 0; i < s.length(); i++) {
      hash += (s.charAt(i) * pow[i]) % MOD;

      hash %= MOD;
    }

    return hash;
  }

  public long updateHash(long hash, char newChar, char prevChar, int patternLen, long pow[]) {
    // hash = (Prime^0 * c0) + (Prime^1 * c1) + (Prime^2 * c2) + (Prime^3 * c3) +
    // ....
    // hash - c0
    // newHash = (Prime^1 * c1) + (Prime^2 * c2) + (Prime^3 * c3) + ....
    long newHash = hash - prevChar;

    // shift
    // newHash = (Prime^0 * c1) + (Prime^1 * c2) + (Prime^2 * c3) + ....

    // newHash = (newHash/PRIME)%MOD;
    newHash = (newHash * modInverse(PRIME, MOD)) % MOD;

    newHash += ((newChar) * pow[patternLen - 1]) % MOD;
    newHash %= MOD;

    return newHash;
  }

  public long modInverse(long a, long mod) {
    return powmod(a, mod - 2, mod);
  }

  public long powmod(long a, long b, long mod) {
    long res = 1;
    a %= mod;
    while (b > 0) {
      if (b % 2 != 0)
        res = (res * a) % mod;

      a = (a * a) % mod;

      b /= 2;
    }
    return res;
  }

  public ArrayList<Integer> search(String txt, String pat) {
    ArrayList<Integer> ans = new ArrayList<>();
    int patlen = pat.length();
    int n = txt.length();

    long pow[] = calcPow(patlen);

    long patHash = calculateHash(pat, pow);

    long currHash = calculateHash(txt.substring(0, patlen), pow);

    for (int i = 0; i <= n - patlen; i++) {
      if (patHash == currHash) {
        if (txt.substring(i, i + patlen).equals(pat))
          ans.add(i + 1);
      }

      if (i + patlen < n)
        currHash = updateHash(currHash, txt.charAt(i + patlen), txt.charAt(i), patlen, pow);
    }

    return ans;
  }
}

class RabinKarpMain {
  public static void main(String[] args) {
    RabinKarp rk = new RabinKarp();
    // String txt = "birthdayboy";
    // String pat = "birth";
    // String txt = "geeksforgeek";
    // String pat = "geek";
    String txt = "ppppppppp";
    String pat = "ppppp";
    System.out.println(rk.search(txt, pat));
  }
}