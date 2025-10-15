package Maths;

public class FermatsLittleTheorem {

  public long modInverse(long a , long MOD){
    return pow(a,MOD-2,MOD);
  }

  public long pow(long x , long p , long M){
    if(p==0) return 1;

    long half = pow(x,p/2,M);

    long res = (half*half)%M;

    return (p%2 == 0) ? res : (x*res)%M;
  }
}


/*
 * Modular inverse of a mod M -> 
 * (1/a)%M =  a^(M-2) % M
 */